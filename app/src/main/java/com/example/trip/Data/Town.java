package com.example.trip.Data;

import java.util.List;

public class Town {
    private String name;
    private String country;
    private int numOfPlaces;
    private List<Place> places;

    public Town(String name, String country, int numOfPlaces){
        this.name = name;
        this.country = country;
        this.numOfPlaces = numOfPlaces;
    }

    public void addPlaces(List<Place> places){
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getNumOfPlaces() {
        return numOfPlaces;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setTown(Town town) {
        this.name = town.getName();
        this.country = town.getCountry();
        this.numOfPlaces = town.getNumOfPlaces();
        this.places = town.getPlaces();
    }
}
