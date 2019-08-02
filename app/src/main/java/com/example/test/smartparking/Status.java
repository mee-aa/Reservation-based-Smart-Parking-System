package com.example.test.smartparking;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Status extends AppCompatActivity {
    private TypedArray navMenuIcons;
    int id1,id2,id3,id4,id5,id6,id7,id8;
    ImageView car1,car2,car3,car4,car5,car6,car7,car8;
    ProgressBar pBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        AppController.initialize(getApplicationContext());
        SharedPreference.initialize(getApplicationContext());
        navMenuIcons = getResources().obtainTypedArray(R.array.cars);
        pBar = (ProgressBar) findViewById(R.id.progress);
        car1 = (ImageView)findViewById(R.id.car1);
        car2 = (ImageView)findViewById(R.id.car2);
        car3 = (ImageView)findViewById(R.id.car3);
        car4 = (ImageView)findViewById(R.id.car4);
        car5 = (ImageView)findViewById(R.id.car5);
        car6 = (ImageView)findViewById(R.id.car6);
        car7 = (ImageView)findViewById(R.id.car7);
        car8 = (ImageView)findViewById(R.id.car8);
    //    id1=1;id2=0;
        getData();



    }

    public void getData() {

        pBar.setVisibility(View.VISIBLE);

        StringRequest request = new StringRequest(Request.Method.POST, Keys.URL.gettest, new Response.Listener<String>() {
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
                                        break;
                                    case 1:
                                        car2.setImageResource(R.drawable.parking);
                                        break;
                                    case 2:
                                        car3.setImageResource(R.drawable.parking);
                                        break;
                                    case 3:
                                        car4.setImageResource(R.drawable.parking);
                                        break;
                                    case 4:
                                        car5.setImageResource(R.drawable.parking);
                                        break;
                                    case 5:
                                        car6.setImageResource(R.drawable.parking);
                                        break;
                                    case 6:
                                        car7.setImageResource(R.drawable.parking);
                                        break;
                                    case 7:
                                        car8.setImageResource(R.drawable.parking);
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
}
