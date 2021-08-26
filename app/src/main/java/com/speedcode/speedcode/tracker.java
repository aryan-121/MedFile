package com.speedcode.speedcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class tracker extends AppCompatActivity {
    ImageButton bmi_button, setting_button;
    Button tracker1, tracker2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        getSupportActionBar().hide();
        bmi_button = findViewById(R.id.bmi_button);
        setting_button = findViewById(R.id.setting_button);
        tracker1 = findViewById(R.id.tracker1);
        tracker2 = findViewById(R.id.tracker2);
        bmi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tracker.this, MainActivity.class);
                startActivity(intent);
            }
        });

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tracker.this, Setting_Activity.class);
                startActivity(intent);
            }
        });
        tracker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tracker.this, SugarTrackerActivity.class);
                startActivity(intent);
            }
        });

    }
}