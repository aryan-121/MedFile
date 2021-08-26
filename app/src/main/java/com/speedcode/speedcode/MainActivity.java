package com.speedcode.speedcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity {
    EditText height ;
    EditText weight ;
    TextView info1, info2, bmiScore, status, greeting;
    Button submit;
    ImageButton setting_button, report_button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        submit = findViewById(R.id.sugarSubmit);
        info1 = findViewById(R.id.info1);
        info2 = findViewById(R.id.info2);
        bmiScore = findViewById(R.id.bmiScore);
        status = findViewById(R.id.status);
        setting_button = findViewById(R.id.setting_button);
        greeting = findViewById(R.id.greeting);
        report_button = findViewById(R.id.report_button);

        SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = sP.getString("name","MR. X");
        greeting.setText("Welcome! "+name);

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Setting_Activity.class);
                startActivity(intent);
            }
        });

        report_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tracker.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height_size_string = height.getText().toString();
                String weight_size_string = weight.getText().toString();

                if(height_size_string.equals("") || weight_size_string.equals("")){
                  Toast.makeText(MainActivity.this, "Please Enter the Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    double height_size = Double.parseDouble(height_size_string);
                    double weight_size = Double.parseDouble(weight_size_string);
                    float bmi;
                    bmi = (float) ((float) (weight_size*10000)/(height_size*height_size));
                    info1.setText("Your BMI :");
                    info2.setText("STATUS   : ");
                    bmiScore.setText(String.format("%.2f", bmi));
                    if(bmi < 18.5){
                        status.setText("Underweight");
                    }
                    else if(bmi < 25){
                        status.setText("Normal   ");
                    }
                    else{
                        status.setText("Overweight");
                    }
                }
            }
        });
    }
}