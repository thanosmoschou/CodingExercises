package com.example.ics22020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.specialityList);
        Button pctButton = findViewById(R.id.pctBtn);

        SurgeonList surgeonListObject;
        List<Surgeon> surgeonsAsList;

        try {
            surgeonListObject = new SurgeonList(getAssets());
            surgeonsAsList = surgeonListObject.getSurgeons();

            List<String> specializations = new ArrayList<>();
            for(Surgeon surg : surgeonsAsList) {
                specializations.add(surg.getSpeciality());
            }

            ArrayAdapter<String> specialAdapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, specializations);
            spinner.setAdapter(specialAdapter);

            pctButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String sp = spinner.getSelectedItem().toString();
                    String sucRate = surgeonListObject.findPercentage(sp);

                    Toast.makeText(MainActivity.this, "Success Rate of speciality: " + sp + " is: " + sucRate + "%", Toast.LENGTH_LONG).show();
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}