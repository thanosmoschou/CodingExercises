/*
Author: Thanos Moschou
Description: This is a simple android project in order to learn how to use
menus and navigation bars. This is based on book "Να ένα Android..." by Chariton Kyprianos.
 */

package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner optionsSpinner;
    List<String> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        optionsSpinner = findViewById(R.id.optionsSpinner);
        optionsSpinner.setOnItemSelectedListener(this); //or you can implement inside this method an anonymous class

        foods = new ArrayList<>();
        foods.add("Souvlaki");
        foods.add("Makaroni");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, foods);
        optionsSpinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        Toast.makeText(getApplicationContext(), getString(R.string.optionsTxt, foods.get(i)), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}