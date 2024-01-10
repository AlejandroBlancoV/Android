package com.example.a029spinnerexamen;

import java.util.List;

public class Team {

    private int photo;
    private String name;
    private String country;
    private String year;

    public Team(int photo, String name, String country, String year) {
        this.photo = photo;
        this.name = name;
        this.country = country;
        this.year = year;
    }
    public static int[] ESCUDO={
        R.drawable.zvezdo;
        R.drawable.maccabbi;
    }

    public static String[] CIUDAD={
            ""
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static List<Team> crearTeam(){

    }
}
