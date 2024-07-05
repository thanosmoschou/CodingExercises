package com.example.thema_2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CityList {
    private List<City> cities;

    public CityList() throws JSONException {
        this.cities = new ArrayList<>();

        JSONArray array = new JSONArray(HttpResult.getResult());

        for(int i = 0; i < array.length(); i++)
        {
            JSONObject obj = array.getJSONObject(i);
            String name = obj.getString("name");
            String monument = obj.getString("monument");
            String country = obj.getString("country");
            String image = obj.getString("image");

            cities.add(new City(name, monument, country, image));
        }
    }

    public List<City> getCities()
    {
        return cities;
    }


    public City findCity(String name)
    {
        for(City c : cities)
            if(c.hasName(name))
                return c;
        return null;
    }


}
