package com.example.lecture6learnhowtoparsexmldata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity
{
    private CarBrandList carBrandList;
    private RadioGroup modelsRadioGroup;
    private Button pickABrandBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            carBrandList = new CarBrandList(getAssets());

            Spinner brandsSpinner = findViewById(R.id.brandsSpinner);

            //adapter needs a context, a layout and our list
            ArrayAdapter<String> brandsAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    carBrandList.getAllBrandsAsStrings());
            brandsSpinner.setAdapter(brandsAdapter); //do not forget to set the adapter to the spinner

            modelsRadioGroup = findViewById(R.id.modelsRadioGroup);

            pickABrandBtn = findViewById(R.id.brandPickBtn);
            pickABrandBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String selectedBrand = brandsSpinner.getSelectedItem().toString();
                    List<String> models = carBrandList.getAllModelsForBrand(selectedBrand);

                    modelsRadioGroup.removeAllViews();

                    for(String model : models)
                    {
                        RadioButton rb = new RadioButton(getApplicationContext());
                        rb.setText(model);

                        modelsRadioGroup.addView(rb);
                    }

                    modelsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            RadioButton sel = findViewById(i);
                            Toast.makeText(getApplicationContext(), "Brand: " + selectedBrand +
                                    " Model: " + sel.getText(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        catch (ParserConfigurationException e)
        {
            throw new RuntimeException(e);
        }
        catch (SAXException e)
        {
            throw new RuntimeException(e);
        }
    }
}