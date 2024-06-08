package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GameList gList = new GameList();
    TextView matchTxt;
    Button nextBtn, showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matchTxt = findViewById(R.id.matchTxt);
        matchTxt.setText(gList.showNextMatch());

        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matchTxt.setText(gList.showNextMatch());
            }
        });

        showBtn = findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game selectedGame = gList.getGame();
                Toast.makeText(getApplicationContext(), selectedGame.whoWins(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}