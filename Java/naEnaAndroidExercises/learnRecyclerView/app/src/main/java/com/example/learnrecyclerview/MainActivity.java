/*
Author: Thanos Moschou
Description: This is a simple project in order to learn about card views, recycler view and glide.
 */

package com.example.learnrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView peopleRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peopleRecyclerView = findViewById(R.id.peopleRecyclerView);

        /*
        When you work with listviews you need to create an array adapter and pass it your arraylist of data.
        Then you need to set the adapter to the listview.
        With Recycler view we need to create our own adapter. We also need a layout file. In list view we can pass a built in layout.
        But now we need to create the layout.
         */

        /*ArrayList<Person> people = new ArrayList<>();
        for(String n : getResources().getStringArray(R.array.names_string_array))
            people.add(new Person(n));*/

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Thanasis", "https://t4.ftcdn.net/jpg/02/14/74/61/360_F_214746128_31JkeaP6rU0NzzzdFC4khGkmqc8noe6h.jpg"));
        people.add(new Person("Eleni", "https://img.freepik.com/free-photo/portrait-young-beautiful-woman-with-smoky-eyes-makeup-pretty-young-adult-girl-posing-studio-closeup-attractive-female-face_186202-4439.jpg"));


        PeopleRecyclerViewAdapter adapter = new PeopleRecyclerViewAdapter(MainActivity.this);
        adapter.setPeople(people);

        peopleRecyclerView.setAdapter(adapter); //In list view I go until this line of code but now I need to write some few things more
        peopleRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        //peopleRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}