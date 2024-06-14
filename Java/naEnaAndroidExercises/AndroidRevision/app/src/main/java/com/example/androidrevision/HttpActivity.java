package com.example.androidrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class HttpActivity extends AppCompatActivity {

    private Button nextBtn, backBtn;
    private TextView temperatureTxt;
    private ImageView picassoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);
        temperatureTxt = findViewById(R.id.temperatureTxt);
        picassoView = findViewById(R.id.picassoImage);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HttpActivity.this, XmlParsing.class);
                startActivity(intent);
            }
        });

        //it is good practise to create a background thread that will make the http request because if the
        //main thread will do the request it will freeze the app
        RequestThread thread = new RequestThread();
        try
        {
            thread.start();
            thread.join();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        String maxTemp = thread.getMaxTemp();
        temperatureTxt.setText(maxTemp);


        //load an image with picasso dependency
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Pablo_picasso_1.jpg/640px-Pablo_picasso_1.jpg";
        Picasso.with(getApplicationContext()).load(Uri.parse(imageUrl)).resize(100, 100).into(picassoView);

    }
}