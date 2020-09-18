package com.example.parkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton autoParking,remoteControl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoParking=findViewById(R.id.autoParking);
        remoteControl=findViewById(R.id.remote_control);
        remoteControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RemoteControlActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}