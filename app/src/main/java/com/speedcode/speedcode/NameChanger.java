package com.speedcode.speedcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameChanger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_changer);
        getSupportActionBar().hide();

        Button saveUserName;
        EditText updatedName;
        saveUserName = findViewById(R.id.saveUserName);
        updatedName = findViewById(R.id.updatedName);
        saveUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = updatedName.getText().toString();
                if(name.equals("")){
                    Toast.makeText(NameChanger.this, "Please Enter the Name ", Toast.LENGTH_SHORT).show();
                }
                else{
                    SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor ed = sP.edit() ;
                    ed.putString("name", name);
                    ed.apply();
                    Toast.makeText(NameChanger.this, "Name Updated Succefully ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NameChanger.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}