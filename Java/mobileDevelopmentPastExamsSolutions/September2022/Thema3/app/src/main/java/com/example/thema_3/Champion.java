package com.example.thema_3;

public class Champion {
    private String name;
    private String year;
    private String logo;

    public Champion(String name, String year, String logo) {
        this.name = name;
        this.year = year;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getLogo() {
        return logo;
    }

    public boolean hasYear(String aYear)
    {
        return this.year.equals(aYear);
    }
}
