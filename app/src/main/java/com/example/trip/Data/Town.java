package com.example.trip.Data;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private String name;
    private String country;
    private int numOfPlaces;
    private ArrayList<Place> places;

    public Town(String name, String country, int numOfPlaces){
        this.name = name;
        this.country = country;
        this.numOfPlaces = numOfPlaces;
    }

    public Town(){
        
    }

    public void addPlaces(ArrayList<Place> places){
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

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setTown(Town town) {
        this.name = town.getName();
        this.country = town.getCountry();
        this.numOfPlaces = town.getNumOfPlaces();
    }
}
