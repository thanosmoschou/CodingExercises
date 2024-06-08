package com.example.lecture10exerciseweatherapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WeatherFragment extends Fragment {


    private static final String TAG = "WeatherFragment";

    private String weatherString = "Current Weather";
    private TextView textWeather;

    public WeatherFragment()
    {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart()
    {
        super.onStart();
        System.out.println(weatherString);
        FetchWeatherTask weatherTask = new FetchWeatherTask(weatherString);
        Thread t = new Thread(weatherTask);

        try
        {
            t.start();
            t.join();
            textWeather.setText(weatherTask.getResult());

        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);

        if(getArguments() != null)
            weatherString = getArguments().getString("location");
        else
            weatherString = "";

        textWeather = rootView.findViewById(R.id.txtWeather);
        textWeather.setText(weatherString);

        return rootView;
    }
}