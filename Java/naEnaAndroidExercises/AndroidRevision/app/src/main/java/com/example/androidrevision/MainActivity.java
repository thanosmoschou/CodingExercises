/*
Author: Thanos Moschou
Description: This is a small project that demonstrates some things I've learned from
mobile development course of UoM Applied informatics course.
 */

package com.example.androidrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Some tips

How to create a new activity with its xml also. Go to File -> New -> Activity -> Empty View Activity -> select the xml file also

Use gradle from the beginning you create a project because if you write a lot of code the building process will be slower
than writing some code, then built, then again write code, build etc...

How to find Device Manager: Burger Menu in the top left -> Tools -> Device manager

Logcat is very important because from there you can see what is wrong with the project.

Add gradle dependencies to the Module:app (not on Project:YourProjectsName)...module app is always shown second
 */
public class MainActivity extends AppCompatActivity {

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //R is a special class that gives us access to a various resources
        nextBtn = findViewById(R.id.nextBtn); //this is the way you can find an element from inside an xml file

        //set a listener for my button
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //let's create an intent to change the screen
                //it needs 2 arguments: the first is the object of the this class (for example MainClass.this) and the second is
                //the object that corresponds to the class I wanna go (that's why I add .class is the object that corresponds to
                //the class for example Thanos.class is the object that corresponds to the Thanos class.)
                Intent newIntent = new Intent(MainActivity.this, RadioButtonsAndSpinners.class);

                //put arguments to the new intent
                //you need a key for the argument and then pass the value itself. I selected "name" as key
                //and "thanos" as a value
                newIntent.putExtra("name", "thanos");
                startActivity(newIntent);
            }
        });
    }
}