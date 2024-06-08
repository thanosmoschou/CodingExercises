/*
Author: Thanos Moschou
Description: This is a simple project in order to learn how to use local sqlite db.
 */

package com.example.learnsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ListView namesList;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesList = findViewById(R.id.namesList);

        dbHandler = new DBHandler(MainActivity.this);
        dbHandler.addName("thanos");
        dbHandler.addName("eleni");

        List<String> names = dbHandler.selectAllNames();

        ArrayAdapter<String> namesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        namesList.setAdapter(namesAdapter);
    }
}