package com.example.footballmatches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    GameList gList;
    TextView matchTxt;
    Button nextBtn, showBtn;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = DBHandler.getInstance(getApplicationContext());
        dbHandler.deleteAllRows();

        gList = new GameList(getAssets());

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
                String homeTeam = selectedGame.getHomeTeam();
                String visitorTeam = selectedGame.getVisitorTeam();
                String winner = selectedGame.whoWins();

                Toast.makeText(getApplicationContext(), "The winner is: " + winner, Toast.LENGTH_SHORT).show();

                dbHandler.addRecord(homeTeam, visitorTeam, winner);

                System.out.println("\n**********");
                for(String s : dbHandler.readDB())
                    System.out.println(s);

            }
        });
    }
}