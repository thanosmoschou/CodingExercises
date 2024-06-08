package com.example.lecture10exerciseweatherapi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FetchWeatherTask implements Runnable
{

    private String result;
    private String location = "Thessaloniki, Greece";
    private String apiKey = "YOUR API KEY";

    public FetchWeatherTask(String location)
    {
        System.out.println("Location: " + location);
        if(location.length() > 0)
            this.location = location;
    }

    public String getResult()
    {
        return this.result;
    }

    public List<String> getWeatherDataFromJson(String jsonStr) throws JSONException
    {
        List<String> resultStrings = new ArrayList<>();

        /*
            Response example:

            This is a json object that has some keys and some values inside. For the key "main" you can see that
            the value is a json object so you can take the initial json object and then call the method
            getJSONObject("yourKeyHere") in order to get the object. If you want now to get a value from the keys
            that are inside this object you can call getString("your key").
            For example response.getJSONObject("yourKey").getJSONObject("main").getString("temp").toString();

            Let's say that you do not want to get a json object from inside the response but you saw a key that has a single value
            just like "visibility". In this case you simply get the initial json object and then getString("your key").

            You may had a json array for a key value. You work exactly like previously...getJSONArray("yourKey"). Inside it has
            some json objects, or just single values, or either json arrays etc....

            For example
            jsonObject.getJSONArray("anotherKey").get(yourIndex).toString() if the json array
            only contains values without keys. You can convert them to any value you want for example integers etc.
            depending on their value.

            jsonObject.getJSONArray("anotherKey").get(index).getString("anotherKey).toString();
            to get a jsonObject from inside the array (with get()) and then get a value from a key inside the json object.

            Similar for every situation...

            { ->Json Object
                "weather": [ -> newJSONObject(response.toString()).getJSONArray("weather").get(0).getString("id").toString();
                                here i get the whole json object, then for the key "weather" i get the json array that is its value
                                then i can see that this array has only one value so with get(0) i get the json object (if something
                                has {} is json object and if it has [] is json array) and then with getString("id") i get
                                the value from the "id" key. Or if you traverse a json array in a for loop you can call
                                getJSONObject(index) instead of get(index). With get you may need type casting
                    {
                        "id": 801,
                        "main": "Clouds",
                        "description": "few clouds",
                        "icon": "02d"
                    }
                ],
                "main": { ->Json Object for key "main"
                    "temp": 18.8, ->simple value... new JSONObject(response.toString()).getJSONObject("main").getString("temp").toString();
                    "feels_like": 18.3,
                    "temp_min": 17.08,
                    "temp_max": 20.01,
                    "pressure": 1007,
                    "humidity": 60
                },
                "visibility": 10000,
                "wind": {
                    "speed": 5.66,
                    "deg": 270
                },
                "clouds": {
                    "all": 19
                },
                "dt": 1717000981,
                "sys": {
                    "type": 2,
                    "id": 2075535,
                    "country": "GB",
                    "sunrise": 1716954685,
                    "sunset": 1717013090
                },
                "timezone": 3600,
                "id": 2643743,
                "name": "London",
                "cod": 200
            }
         */

        JSONObject jsonObject = new JSONObject(jsonStr);
        String temperature = jsonObject.getJSONObject("main").getString("temp").toString();
        String minTemp = jsonObject.getJSONObject("main").getString("temp_min").toString();
        String maxTemp = jsonObject.getJSONObject("main").getString("temp_max").toString();
        String msg = "Location: " + location + " Current Temp: " + temperature + " Min temp: " + minTemp
                + " Max temp: " + maxTemp;

        resultStrings.add(msg);
        return resultStrings;
    }


    @Override
    public void run()
    {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&mode=json&units=metric&APPID=" + apiKey;

        //Template code from postman
        OkHttpClient client = new OkHttpClient().newBuilder().build(); //create the client for the http call
        MediaType mediaType = MediaType.parse("text/plain"); //create the media type
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .build();

        Response response = null;

        try
        {
            response = client.newCall(request).execute();
            String data = response.body().string();
            try
            {
                result = getWeatherDataFromJson(data).get(0);
            }
            catch (JSONException e)
            {
                throw new RuntimeException(e);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
