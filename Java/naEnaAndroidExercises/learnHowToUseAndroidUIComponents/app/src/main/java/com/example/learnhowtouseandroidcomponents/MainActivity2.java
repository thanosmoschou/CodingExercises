package com.example.learnhowtouseandroidcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {

    Button prevBtn;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //put an image as a background to my activity...make sure you give the activity an id
        View view = findViewById(R.id.newActivity);
        view.setBackground(this.getResources().getDrawable(R.drawable.city)); //images are stored to the drawable folder inside res folder

        prevBtn = findViewById(R.id.prevBtn);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //terminate the activity
            }
        });

        videoView = findViewById(R.id.videoViewer);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.jungle; //skip the file extension
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);
        videoView.start();
    }
}