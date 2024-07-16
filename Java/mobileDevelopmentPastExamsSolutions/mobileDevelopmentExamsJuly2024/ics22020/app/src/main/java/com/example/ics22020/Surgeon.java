package com.example.ics22020;

import java.util.ArrayList;

public class Surgeon {
    String speciality;
    ArrayList<Integer> success;

    public Surgeon(String s) {
        speciality = s;
        success = new ArrayList<Integer>();
    }

    public void addSuccess(Integer s) {
        success.add(s);
    }

    public double calcSuccessRate() {
        int sucCtr = 0;

        for(Integer i : success)
            if(i == 1)
                sucCtr++;

        return (double) sucCtr / success.size() * 100;
    }

    public boolean hasSpecialization(String special) {
        return this.speciality.equals(special);
    }

    public String getSpeciality() {
        return speciality;
    }

    public ArrayList<Integer> getSuccess() {
        return success;
    }



}

