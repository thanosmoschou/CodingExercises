/*
Author: Thanos Moschou
Description: This is a simple project in order to learn about card views, recycler view and glide.
 */

package com.example.learnrecyclerview;

public class Person
{
    private String nameField;
    private String imageUrl;

    public Person(String aNameField, String anImageUrl)
    {
        this.nameField = aNameField;
        this.imageUrl = anImageUrl;
    }

    public String getNameField()
    {
        return nameField;
    }

    public void setNameField(String nameField)
    {
        this.nameField = nameField;
    }

    public String getImageUrl()
    {
        return this.imageUrl;
    }

    @Override
    public String toString()
    {
        return "Name{" +
                "nameField='" + nameField + '\'' +
                '}';
    }
}
