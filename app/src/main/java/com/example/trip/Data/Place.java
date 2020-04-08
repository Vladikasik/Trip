package com.example.trip.Data;

public class Place {
    String name;
    int category;

    String info;

    public Place(String name, int category, String info){
        this.name = name;
        this.category = category;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public String getInfo() {
        return info;
    }


}
