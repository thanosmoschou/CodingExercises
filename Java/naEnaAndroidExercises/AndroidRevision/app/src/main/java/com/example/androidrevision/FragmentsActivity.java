package com.example.androidrevision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/*
Some tips on fragments:
Create fragment(not activity): file -> new -> activity -> empty views activity
Create a layout for your fragment just like you would have done in a layout file.
Now create an activity that will store your fragment.
Inside the activity xml put a fragment container view and inside there you will add the fragment.
Now inside the .java file of your activity load the fragment
 */

public class FragmentsActivity extends AppCompatActivity {

    private Button changeFragmentBtn, nextBtn, backBtn;
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        //get the arguments from the bundle
        Bundle bundle = getIntent().getExtras();

        //you can also assign this bundle to the fragment as argument
        FragmentExercise firstFragment = new FragmentExercise();
        firstFragment.setArguments(bundle);

        //add the fragment to the fragment container frame layout
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, firstFragment).commit();


        changeFragmentBtn = findViewById(R.id.changeFragmentBtn);
        changeFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if(isFirst)
                {
                    transaction.replace(R.id.fragmentContainerView, new FragmentExercise2());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else
                {
                    transaction.replace(R.id.fragmentContainerView, new FragmentExercise());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

                isFirst = !isFirst;
            }
        });

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        nextBtn = findViewById(R.id.nextBtn); //you may have buttons with the same id within your app but it searches inside this activity for this id
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent httpIntent = new Intent(FragmentsActivity.this, HttpActivity.class);
                startActivity(httpIntent);
            }
        });

    }
}