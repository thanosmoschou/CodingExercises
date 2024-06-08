/*
Author: Thanos Moschou
Description: This is a simple android project in order to learn how to use
menus and navigation bars. This is based on book "Να ένα Android..." by Chariton Kyprianos.
 */

package com.example.menus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Menu optionsMenu;
    Button nextBtn;
    Button navBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

        navBtn = findViewById(R.id.navBtn);
        navBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });

    }

    //To show the menu I need to override 2 methods
    //I also needed to change the theme to Theme.AppCompat explicitly to my Manifest file for some reason
    //I can use a Toolbar component straight to my activity main xml if I want to skip the programming part
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        optionsMenu = menu;

        //optionsMenu.getItem(0).setVisible(false); to hide an option

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.option1)
            Toast.makeText(MainActivity.this, "You selected option1", Toast.LENGTH_SHORT).show();
        else if(item.getItemId() == R.id.option2)
            Toast.makeText(MainActivity.this, "You selected option2", Toast.LENGTH_SHORT).show();
        else if(item.getItemId() == R.id.option3)
        {
            StringBuilder msg = new StringBuilder("You selected option3");

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Android");
            builder.setMessage(msg);
            builder.show();
        }

        return true;
    }
}