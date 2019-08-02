package com.example.test.smartparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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

public class booked extends AppCompatActivity {
    ImageView car1,car2,car3,car4,car5,car6,car7,car8;
ProgressBar pBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        AppController.initialize(getApplicationContext());
        SharedPreference.initialize(getApplicationContext());
        car1 = (ImageView) findViewById(R.id.car1);
        pBar = (ProgressBar) findViewById(R.id.progress);
        car2 = (ImageView)findViewById(R.id.car2);
        car3 = (ImageView)findViewById(R.id.car3);
        car4 = (ImageView)findViewById(R.id.car4);
        car5 = (ImageView)findViewById(R.id.car5);
        car6 = (ImageView)findViewById(R.id.car6);
        car7 = (ImageView)findViewById(R.id.car7);
        car8 = (ImageView)findViewById(R.id.car8);
        getData();

        car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(booked.this,Form.class);
                SharedPreference.save("placeid","1");
                startActivity(i);
            }
        });
        car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(booked.this,Form.class);
                SharedPreference.save("placeid","2");
                startActivity(i);
            }
        });
        car3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(booked.this,Form.class);
                SharedPreference.save("placeid","3");
                startActivity(i);
            }
        });
        car4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(booked.this,Form.class);
                SharedPreference.save("placeid","4");
                startActivity(i);
            }
        });
        car5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(booked.this,Form.class);
                SharedPreference.save("placeid","5");
                startActivity(i);
            }
        });
        car6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(booked.this,Form.class);
                SharedPreference.save("placeid","6");
                startActivity(i);
            }
        });
        car7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(booked.this,Form.class);
                SharedPreference.save("placeid","7");
                startActivity(i);
            }
        });
        car8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(booked.this,Form.class);
                SharedPreference.save("placeid","8");
                startActivity(i);
            }
        });
    }
    public void getData() {

        pBar.setVisibility(View.VISIBLE);

        StringRequest request = new StringRequest(Request.Method.POST, Keys.URL.getlist, new Response.Listener<String>() {
            @Override
            public void onResponse(String arg0) {
                pBar.setVisibility(View.GONE);
                try {
                    JSONObject json = new JSONObject(arg0);
                    String str = json.getString("data");
                    //String str = "00001000";
                    String[] res = new String[str.length()];
                    for (int i = 0; i < str.length(); i++) {
                        res[i] = Character.toString(str.charAt(i));
                        Log.i("=>",Integer.parseInt(res[i])+"");
                        if(Integer.parseInt(res[i])==0){
                            //navMenuIcons.getResourceId(Integer.parseInt(res[i]), -1);
                            switch (i){
                                case 0:
                                    car1.setImageResource(R.drawable.parkingbook);
                                    break;
                                case 1:
                                    car2.setImageResource(R.drawable.parkingbook);
                                    break;
                                case 2:
                                    car3.setImageResource(R.drawable.parkingbook);
                                    break;
                                case 3:
                                    car4.setImageResource(R.drawable.parkingbook);
                                    break;
                                case 4:
                                    car5.setImageResource(R.drawable.parkingbook);
                                    break;
                                case 5:
                                    car6.setImageResource(R.drawable.parkingbook);
                                    break;
                                case 6:
                                    car7.setImageResource(R.drawable.parkingbook);
                                    break;
                                case 7:
                                    car8.setImageResource(R.drawable.parkingbook);
                                    break;
                            }
                            //((ImageView)findViewById(navMenuIcons.getResourceId(i+1, -1))).setImageResource(R.drawable.parkingbook);
                        }else{
                            //navMenuIcons.getResourceId(Integer.parseInt(res[i]), -1);
                            switch (i){
                                case 0:
                                    car1.setImageResource(R.drawable.parking);
                                    car1.setEnabled(false);
                                    break;
                                case 1:
                                    car2.setImageResource(R.drawable.parking);
                                    car2.setEnabled(false);
                                    break;
                                case 2:
                                    car3.setImageResource(R.drawable.parking);
                                    car3.setEnabled(false);
                                    break;
                                case 3:
                                    car4.setImageResource(R.drawable.parking);
                                    car4.setEnabled(false);
                                    break;
                                case 4:
                                    car5.setImageResource(R.drawable.parking);
                                    car5.setEnabled(false);
                                    break;
                                case 5:
                                    car6.setImageResource(R.drawable.parking);
                                    car6.setEnabled(false);
                                    break;
                                case 6:
                                    car7.setImageResource(R.drawable.parking);
                                    car7.setEnabled(false);
                                    break;
                                case 7:
                                    car8.setImageResource(R.drawable.parking);
                                    car8.setEnabled(false);
                                    break;
                            }
                            //((ImageView)findViewById(navMenuIcons.getResourceId(i+1, -1))).setImageResource(R.drawable.parking);
                        }


                    }

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
                params.put("id", "1");

                return params;
            }
        };

        AppController.getInstance().add(request);


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(booked.this,MainActivity.class);
        startActivity(i);
    }
}
