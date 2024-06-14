package com.example.androidrevision;

public class RequestThread extends Thread
{
    private String maxTemp;

    public RequestThread(){}

    public void run()
    {
        OkHttpHandler okHttpHandler = new OkHttpHandler(); //this thread will handle the request
        maxTemp = okHttpHandler.getWeatherData();
    }

    public String getMaxTemp()
    {
        return maxTemp;
    }
}
