package com.example.test.smartparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView status,booked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (ImageView)findViewById(R.id.status);
        booked = (ImageView)findViewById(R.id.booked);
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Status.class);
                startActivity(i);
            }
        });
        booked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,booked.class);
                startActivity(i);
            }
        });
    }

    public void onBackPressed() {
        CustomDialog.ExitAppDialog(MainActivity.this);
    }
}
