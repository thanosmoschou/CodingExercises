package com.example.thema_2;

public class City {
    private String name;
    private String monument;
    private String country;
    private String image;

    public City(String name, String monument, String country, String image) {
        this.name = name;
        this.monument = monument;
        this.country = country;
        this.image = image;
    }

    public boolean hasName(String aName)
    {
        return this.name.equals(aName);
    }

    public String getName() {
        return name;
    }

    public String getMonument() {
        return monument;
    }

    public String getCountry() {
        return country;
    }

    public String getImage() {
        return image;
    }
}
