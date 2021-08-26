package com.speedcode.speedcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Setting_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();
        Button setting1, setting2;
        ImageButton bmi_button, report_button;
        setting1 = findViewById(R.id.tracker1);
        bmi_button = findViewById(R.id.bmi_button);
        setting2 = findViewById(R.id.tracker2);
        report_button = findViewById(R.id.report_button);
        bmi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        report_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_Activity.this, tracker.class);
                startActivity(intent);
            }
        });

        setting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_Activity.this, creators_Activity.class);
                startActivity(intent);
            }
        });
        setting1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_Activity.this, NameChanger.class);
                startActivity(intent);
            }
        });

    }
}