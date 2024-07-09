package com.example.thema_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    ImageView championView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        championView = findViewById(R.id.championLogoImage);

        Intent intent = getIntent();
        String logo = intent.getStringExtra("logo");
        String name = intent.getStringExtra("name");

        Picasso.with(getApplicationContext()).load(Uri.parse(logo)).resize(150, 150).into(championView);
        Toast.makeText(getApplicationContext(), "Champion is: " + name, Toast.LENGTH_LONG).show();
    }
}