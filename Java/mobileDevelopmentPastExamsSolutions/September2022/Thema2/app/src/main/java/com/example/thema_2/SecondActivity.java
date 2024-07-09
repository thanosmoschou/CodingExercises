package com.example.thema_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultTxt = findViewById(R.id.resultTxt);

        Intent intent = getIntent();
        String input = intent.getStringExtra("input");

        Calculator calc = new Calculator(input);
        resultTxt.setText("Result is: " + Integer.toString(calc.multi()));
    }
}