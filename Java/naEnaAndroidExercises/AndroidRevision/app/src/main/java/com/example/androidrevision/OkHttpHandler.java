package com.example.androidrevision;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


//A request thread will have a handler object as an attribute, will make the request and get the data.
public class OkHttpHandler
{
    private String demoIP = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=temperature_2m_max,temperature_2m_min";

    public OkHttpHandler()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public String getWeatherData()
    {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, ""); //unnecessary here
        Request request = new Request.Builder()
                .url(demoIP)
                .method("GET", null) //get does not need a request body
                .build();

        Response response = null;
        JSONObject jsonObject = null;
        String maxTemp = null;

        try
        {
            response = client.newCall(request).execute();

            // You should only call response.body().string() once because the response body can be consumed only one time.
            // If you need to log the response body and also parse it as a JSON object, you should store the string in
            // a variable first and then use it for both logging and parsing.
            // not toString but string...this returns the response as a string format...
            String responseInStringFormat = response.body().string();
            jsonObject = new JSONObject(responseInStringFormat);
            System.out.println(response.body().toString()); //this prints the address of response body object
            System.out.println(responseInStringFormat); //this prints the same with the following line
            System.out.println(jsonObject);

            //Let's analyze the json response
            /*
            If you see something like {anything inside the curly braces} it is a json object
            If you see something like [anything inside the square brackets] it is a json array

            Inside json array or json object you can have other json arrays or json objects...

            For example you can have a json array inside a json object and vice versa.

            Also json array can have only numeric values, strings etc. It is not necessary it contains json objects
            but it can have. Check "temperature_2m_max" key. Keep in mind that json object could only have numeric values
            also, but it could have json arrays, json objects etc just like json arrays. They can have the same type of values

            The data inside the json object will have the following format:
            key: value
            with key you can access the value
            value can be anything (string, int, float, json object, json array etc)

            for example
            {
                "myKey": 1,
                "mySecondKey": "hello",
                "myThirdKey": 1.34343,
                "fourth": {
                            "nested": 12,
                            "nestedArray": [
                                            {
                                              "nestedNested": "hello"
                                             },
                                             {
                                                "nestedNested2": "asdafa"
                                             }
                                            ]
                           },
                 "array": [
                            1,
                            2,
                            3,
                            4
                          ]
            }

            also the format of json array:

            [
             1,
             2,
             4
            ]

            or

            [
                {
                    //something here
                },
                {
                    //something here
                }
            ]

            In the following json response you can see that "latitude" key has a float value and "daily_units" has a json object as a value

            How to access the data:
            It depends on the value type. For example with the following you get something as a string
            jsonObject.getString("latitude") -> this returns the value of "latitude" in string format

            but you see that this value is double...no problem, you can take it as a double
            jsonObject.getDouble("latitude") -> this returns the value of "latitude" as a double

            If the value is numeric you can take it as string or as its type(int, double etc)
            but if the value is string, you will take it as string

            How to take a value if it is json object
            jsonObject.getJSONObject("daily_units")
            now you can access the nested values with the same way I mentioned previously

            For example take the "time" value of the json object "daily_units" (assume that I did not store the
            json object to a variable so I will have a method chain)

            JSONObject jsonObject = new JSONObject(response.body().string());
            jsonObject.getJSONObject("daily_units").getString("time")

            How to access the data of a json array. See the "daily" key. It has a json object as a value.
            Inside this json object the "time" key has a json array as a value. Let's take this array and traverse the data

            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONArray array = jsonObject.getJSONObject("daily").getJSONArray("time");

            String firstValue = array.getString(0);

            or

            String firstValueOther = (String) array.get(0); //this needs casting because get returns Object...call toString or (String) at the beginning

            or

            String firstValueOther2 = array.get(0).toString();

            Again you can take the numeric values as string or as its type with the same way I mentioned earlier...
            getString("something") or getDouble("something") or getInt("something")...

            {
                "latitude": 52.52,
                "longitude": 13.419998,
                "generationtime_ms": 0.07092952728271484,
                "utc_offset_seconds": 0,
                "timezone": "GMT",
                "timezone_abbreviation": "GMT",
                "elevation": 38.0,
                "daily_units": {
                    "time": "iso8601",
                    "temperature_2m_max": "°C",
                    "temperature_2m_min": "°C"
                },
                "daily": {
                    "time": [
                        "2024-06-14",
                        "2024-06-15",
                        "2024-06-16",
                        "2024-06-17",
                        "2024-06-18",
                        "2024-06-19",
                        "2024-06-20"
                    ],
                    "temperature_2m_max": [
                        18.6,
                        20.4,
                        22.9,
                        25.2,
                        24.8,
                        21.5,
                        18.7
                    ],
                    "temperature_2m_min": [
                        10.7,
                        12.8,
                        10.6,
                        14.5,
                        17.8,
                        16.4,
                        13.3
                    ]
                }
            }
             */

            String latitude = jsonObject.getString("latitude");
            double latitudeAsDouble = jsonObject.getDouble("latitude");
            JSONObject units = jsonObject.getJSONObject("daily_units");
            System.out.println(latitude);
            System.out.println(latitudeAsDouble);

            JSONArray jsonArray = jsonObject.getJSONObject("daily").getJSONArray("time");
            String firstValue = jsonArray.getString(0);
            String firstValueOther = (String) jsonArray.get(0); //this needs casting because get returns Object...call toString or (String) at the beginning
            String firstValueOther2 = jsonArray.get(0).toString();

            System.out.println(firstValue + " " + firstValueOther + " " + firstValueOther2);

            maxTemp = jsonObject.getJSONObject("daily").getJSONArray("temperature_2m_max").getString(0);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        catch (JSONException e)
        {
            throw new RuntimeException(e);
        }


        return maxTemp;
    }
}
