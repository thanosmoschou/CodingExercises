package com.example.thema_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.json.JSONException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.cityRg);
        nextBtn = findViewById(R.id.nextBtn);

        CityList cityList;
        List<City> cities;

        try {
            cityList = new CityList();
            cities = cityList.getCities();

            int ctr = 1;
            for(City c : cities)
            {
                RadioButton rb = new RadioButton(getApplicationContext());
                rb.setId(ctr++);
                rb.setText(c.getName());
                rg.addView(rb);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton selected = findViewById(rg.getCheckedRadioButtonId());
                String name = selected.getText().toString();

                City selectedCity = cityList.findCity(name);

                Intent nextActivity = new Intent(MainActivity.this, SecondActivity.class);
                nextActivity.putExtra("name", selectedCity.getName());
                nextActivity.putExtra("monument", selectedCity.getMonument());
                nextActivity.putExtra("country", selectedCity.getCountry());
                nextActivity.putExtra("image", selectedCity.getImage());

                startActivity(nextActivity);
            }
        });
    }
}