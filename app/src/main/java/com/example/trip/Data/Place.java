package com.example.trip.Data;

public class Place {
    String name;
    int category;

    String info;

    public Place(String name, int category){
        this.name = name;
        this.category = category;
        this.info = "Info about this place will be updated";
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
