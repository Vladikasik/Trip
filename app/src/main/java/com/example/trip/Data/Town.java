package com.example.trip.Data;

import java.util.List;

public class Town {
    String name;
    String country;
    int numOfPlaces;
    List<Place> places;

    public Town(String name, String country, int numOfPlaces){
        this.name = name;
        this.country = country;
        this.numOfPlaces = numOfPlaces;
    }

    public void addPlaces(List<Place> places){
        this.places = places;
    }
}
