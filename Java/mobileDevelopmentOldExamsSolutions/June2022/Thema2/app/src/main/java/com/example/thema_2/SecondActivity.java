package com.example.thema_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    private ImageView cityImage;
    private TextView msg;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        cityImage = findViewById(R.id.cityImage);
        msg = findViewById(R.id.msg);
        backBtn = findViewById(R.id.backBtn);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String monument = intent.getStringExtra("monument");
        String country = intent.getStringExtra("country");
        String image = intent.getStringExtra("image");

        msg.setText("Thousands of visitors have visited " + monument + ", in " + name + " (" + country + "), this year.");

        System.out.println(image);
        Picasso.with(getApplicationContext()).load(Uri.parse(image)).resize(100, 100).into(cityImage);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}