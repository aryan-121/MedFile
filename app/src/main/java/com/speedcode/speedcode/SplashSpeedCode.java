package com.speedcode.speedcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static android.os.SystemClock.sleep;

public class SplashSpeedCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_speed_code);
        getSupportActionBar().hide();

        Thread thread = new Thread(){
        public void run() {
            try {
                sleep(4000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Intent intent = new Intent(SplashSpeedCode.this, MainActivity.class);
                startActivity(intent);
            }
        }
        };thread.start();
    }
}