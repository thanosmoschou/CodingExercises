package com.example.lecture6learnhowtoparsexmldata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarBrand
{
    private String brandName;
    private List<String> modelsList;

    public CarBrand(String brandName, String models)
    {
        this.brandName = brandName;
        this.modelsList = Arrays.asList(models.split(", "));
    }

    public boolean isBrandOf(String aBrand)
    {
        return this.brandName.equals(aBrand);
    }

    public void addModel(String model)
    {
        this.modelsList.add(model);
    }

    public String getBrandName()
    {
        return brandName;
    }

    public List<String> getModelsList()
    {
        return modelsList;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public void setModelsList(List<String> modelsList)
    {
        this.modelsList = modelsList;
    }
}
