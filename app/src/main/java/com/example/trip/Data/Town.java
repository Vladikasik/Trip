package com.example.trip.Data;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private String name;
    private String country;
    private ArrayList<Place> places = new ArrayList<Place>();

    public Town(String name, String country){
        this.name = name;
        this.country = country;
    }

    public Town(){

    }

    public void addPlace(Place place){
        this.places.add(place);
    }

    public String getName() { return name; }

    public String getCountry() {
        return country;
    }


    public ArrayList<Place> getPlaces() {
        return places;
    }

    public int numOfPlaces(){ return this.places.size();}

    public void setTown(Town town){
        this.name = town.getName();
        this.country = town.getCountry();
        this.places = town.getPlaces();
    }

    public void printPlaces(){
        for (Place place : places){
            place.print();
        }
    }

}
