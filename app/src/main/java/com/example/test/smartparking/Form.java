package com.example.test.smartparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Form extends AppCompatActivity {
    EditText name, emil, number,cardetails;
    Button submit;
ProgressBar pBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        AppController.initialize(getApplicationContext());
        SharedPreference.initialize(getApplicationContext());
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.mobile);
        pBar = (ProgressBar)findViewById(R.id.progress);
        emil = (EditText) findViewById(R.id.email);
        cardetails= (EditText) findViewById(R.id.carnumber);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardetails.getText().toString().equals("")){
                    Toast.makeText(Form.this, "Please fill details..", Toast.LENGTH_SHORT).show();
                }
                else {
                    getData(name.getText().toString(),number.getText().toString(),emil.getText().toString(),cardetails.getText().toString());
                }
            }
        });
    }



    public void getData(final String name,final String number,final String email,final String cardetails) {

        pBar.setVisibility(View.VISIBLE);

        StringRequest request = new StringRequest(Request.Method.POST, Keys.URL.savedata, new Response.Listener<String>() {
            @Override
            public void onResponse(String arg0) {
                pBar.setVisibility(View.GONE);
                Log.i("str",arg0);
                try {
                    JSONObject json = new JSONObject(arg0);

                    if(json.getString("success").equals("0")){
                        Toast.makeText(Form.this, json.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                        Toast.makeText(Form.this, "Booking Completed", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Form.this,booked.class);
                        startActivity(i);
                        finish();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError arg0) {
                pBar.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext(), "Please check IP address you have entered", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("placeid", SharedPreference.get("placeid"));
                params.put("cardetails", cardetails);
                params.put("name",name);
                params.put("mobileno", number);
                params.put("emailid", email);

                return params;
            }
        };

        AppController.getInstance().add(request);


    }
}
