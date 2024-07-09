/*
The original exercise needs a backend that returns a json response...I do not implement a backend for that so
I will parse an xml instead.
 */

package com.example.thema_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    Button viewBtn;
    ChampionsList championsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.championsRg);
        viewBtn = findViewById(R.id.viewBtn);

        try {
            championsList = new ChampionsList(getAssets());
            List<Champion> champions = championsList.getChampions();

            int ctr = 100;
            for(Champion c : champions)
            {
                RadioButton rb = new RadioButton(getApplicationContext());
                rb.setId(ctr);
                rb.setText(c.getYear());
                rg.addView(rb);
                ctr++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton selected = findViewById(rg.getCheckedRadioButtonId());
                String year = selected.getText().toString();
                Champion ch = championsList.getChampionByYear(year);

                String logoUrl = ch.getLogo();
                String name = ch.getName();

                Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                secondIntent.putExtra("logo", logoUrl);
                secondIntent.putExtra("name", name);

                startActivity(secondIntent);

            }
        });
    }
}