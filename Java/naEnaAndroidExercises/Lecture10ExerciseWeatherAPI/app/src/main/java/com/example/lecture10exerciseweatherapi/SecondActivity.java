package com.example.lecture10exerciseweatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        TextView txtGreeting = findViewById(R.id.txtGreeting);
        String location = intent.getStringExtra("location");
        txtGreeting.setText("Temperature for " + location + ": ");

        //Create a bundle, pass arguments to it and then pass the bundle to the fragment
        Bundle bundle = new Bundle();
        bundle.putString("location", location);

        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment2, fragment, "anyTagName").commit();
    }
}