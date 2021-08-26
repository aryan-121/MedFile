package com.speedcode.speedcode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SugarTrackerActivity extends AppCompatActivity {
    EditText inputTextY;
    Button insertButton;
    GraphView graphView;
    DatabaseHandler dbh;
    SQLiteDatabase sqLiteDatabase;
    LineGraphSeries<DataPoint> dataseries = new LineGraphSeries<>(new DataPoint[0]);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_tracker);
        getSupportActionBar().hide();
        inputTextY = findViewById(R.id.sugarIntake);
        insertButton = findViewById(R.id.sugarSubmit);
        graphView = findViewById(R.id.graphView);
        dbh = new DatabaseHandler(this);
        sqLiteDatabase = dbh.getWritableDatabase();
        graphView.addSeries(dataseries);
        graphView.getGridLabelRenderer().setNumVerticalLabels(3);
        insertData();

    }
    public void insertData(){
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long xValue = new Date().getTime();
                int yValue = Integer.parseInt(String.valueOf(inputTextY.getText()));
                dbh.insertToData(xValue, yValue);
                dataseries.resetData(grabData());
            }
        });
    }
    private DataPoint[] grabData(){
        String[] columns = {"xValue","yValue"};
        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.query("Table1", null, null, null, null, null, null);
        DataPoint[] dataPoints = new DataPoint[cursor.getCount()];
        for(int i = 0 ; i < cursor.getCount() ; i++){
            cursor.moveToNext();
            dataPoints[i] = new DataPoint((i+1), cursor.getInt(1));
        }
        return dataPoints;
    }
}