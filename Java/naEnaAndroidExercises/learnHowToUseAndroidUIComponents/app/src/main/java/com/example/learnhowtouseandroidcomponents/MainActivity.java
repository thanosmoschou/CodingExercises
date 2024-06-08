/*
Author: Thanos Moschou
Description: This is a simple project to learn how to use ui components
in Android development. It is based on book "Να ένα Android" from Chariton
Kyprianos.

Not my best code but I am still learning...
 */

package com.example.learnhowtouseandroidcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imgButton;
    ProgressBar bar;
    ImageView view;
    Button nextBtn;
    static MediaPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.imageView);
        imgButton = findViewById(R.id.imagebutton);
        imgButton.setBackgroundResource(R.drawable.my_button);

        //I specify listeners to my buttons with 2 ways. One is with
        //onClick xml attribute and the second one is the following
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bar.getVisibility() == ProgressBar.VISIBLE)
                    bar.setVisibility(ProgressBar.INVISIBLE);
                else
                    bar.setVisibility(ProgressBar.VISIBLE);

                Toast.makeText(getApplicationContext(), "You pressed the button for the progress bar!", Toast.LENGTH_SHORT).show();
            }
        });

        bar = findViewById(R.id.progressBar);
        bar.setVisibility(ProgressBar.INVISIBLE);

        nextBtn = findViewById(R.id.nextActivityBtn);

        MainActivity.soundPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nosleep);
    }

    //Keep in mind that each UI element is a View object
    public void sayHello(View v)
    {
        TextView msgTxt = findViewById(R.id.msgTxt);
        EditText input = findViewById(R.id.input);
        String name = input.getText().toString();

        //In the getString I pass the name of the static string value
        //that I want to receive and the input that user gave (this goes
        //to %s in the <string> element -> format args)
        msgTxt.setText(getString(R.string.userHello, name));

        //change image to the ImageView component
        if(name.equalsIgnoreCase("Thanos"))
        {
            view.setImageResource(R.drawable.male);

            if(MainActivity.soundPlayer.isPlaying())
            {
                MainActivity.soundPlayer.pause();
                MainActivity.soundPlayer.seekTo(0);
                MainActivity.soundPlayer.start();
            }
            else
                MainActivity.soundPlayer.start();
        }
        else if(name.equalsIgnoreCase("Eleni"))
            view.setImageResource(R.drawable.female);
        else
            view.setImageResource(R.drawable.ic_launcher_foreground);


    }

    //these is another method of the activity lifecycle
    @Override
    protected void onStop()
    {
        if(MainActivity.soundPlayer.isPlaying())
        {
            MainActivity.soundPlayer.pause();
            MainActivity.soundPlayer.seekTo(0);
            super.onStop();
        }
    }

    public void changeActivity(View v)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }
}