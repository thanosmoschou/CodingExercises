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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class RadioButtonsAndSpinners extends AppCompatActivity {

    private RadioGroup rgGroup;
    private Spinner spinner;
    private Button backBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_buttons_and_spinners);

        //Let's take the arguments for this intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name"); //get the string with this key...similar it has methods for taking integers, floats etc.
        System.out.println(name); //this will be printed to logcat

        rgGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        backBtn = findViewById(R.id.backBtn);
        nextBtn = findViewById(R.id.nextBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //this is how you terminate an intent
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(RadioButtonsAndSpinners.this, FragmentsActivity.class);

                //you can also put bundles to the intent
                //keep in mind that bundles can also be used in fragments, activities etc.
                Bundle bundle = new Bundle();
                bundle.putString("random", "kostas"); //key-value pairs like putExtra in intents

                nextIntent.putExtras(bundle);
                startActivity(nextIntent);
            }
        });

        //Let's read the string array from strings.xml and create a radio button for each value
        String[] foods = getResources().getStringArray(R.array.foodsArray);

        int ctr = 0;
        for(String f : foods)
        {
            RadioButton rb = new RadioButton(getApplicationContext());
            rb.setId(ctr);
            rb.setText(f);
            rgGroup.addView(rb);
            ctr++;
        }

        //create a toast message for the selected value of the radiogroup
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //find the radio button
                int rbId = radioGroup.getCheckedRadioButtonId();
                RadioButton selected = findViewById(rbId);
                String value = selected.getText().toString();

                Toast.makeText(getApplicationContext(), value + " selected", Toast.LENGTH_SHORT).show();
            }
        });

        //Let's load some values to our spinner. It needs an adapter
        //Load the names first...they could be in string array also
        //the <string name="something">Some text</string> can have arguments as well
        //for example <string name="something">Some text %s</string> and you can pass something
        //like this: getResources().getString(R.string.something, "some text"); and they will be concatenated

        String thanos = getResources().getString(R.string.thanos);
        String eleni = getResources().getString(R.string.eleni);
        String tasos = getResources().getString(R.string.something, "Tasos");

        List<String> names = List.of(thanos, eleni, tasos);

        //The adapter's constructor needs 3 arguments: the application context,
        // a simple layout for the items in the spinner and the list with the data for the spinner
        //If you wanted to load this data to a radio group, you still would have to create a list, traverse the list
        //and for each value you would need to create a radio button, give it an id in order to find it later,
        //set a text to it and then add it to the radio group
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names);
        spinner.setAdapter(namesAdapter);

        //create a toast message
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), adapterView.getSelectedItem().toString() + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}