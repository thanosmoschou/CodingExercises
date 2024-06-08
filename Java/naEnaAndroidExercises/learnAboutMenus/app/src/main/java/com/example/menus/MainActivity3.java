/*
Author: Thanos Moschou
Description: This is a simple android project in order to learn how to use
menus and navigation bars. This is based on book "Να ένα Android..." by Chariton Kyprianos.
 */

package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {

    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        navView = findViewById(R.id.navMenu);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(getApplicationContext(), getString(R.string.optionsTxt, item.getTitle()), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


}