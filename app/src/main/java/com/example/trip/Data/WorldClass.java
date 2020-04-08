package com.example.trip.Data;

import java.util.ArrayList;

public class WorldClass {

    private ArrayList<Town> towns = new ArrayList<>();
    private static WorldClass sInstance;

    private Place addPlace(String namePlace, int category) {
        String info = "This info will be updated";
        Place place = new Place(namePlace, category, info);
        return place;
    }

    public ArrayList<Town> getTowns(){
        return this.towns;
    }

    private void addTown(String nameTown, String country, int numOfPlaces, ArrayList<Place> places) {

        Town town = new Town(nameTown, country, numOfPlaces);

        town.addPlaces(places);

        towns.add(town);
    }

    private void addAll() {

        ArrayList<Place> places = new ArrayList<>();

        places.add(addPlace("The Red Square", 0));
        places.add(addPlace("Novodevichy Convent", 666));
        places.add(addPlace("Planetarium", 6));
        places.add(addPlace("Peredelkino", 666));

        addTown("Moscow", "Russia", places.size(), places);

        ArrayList<Place> placest = new ArrayList<>();

        placest.add(addPlace("Sydney jopera", 5));
        placest.add(addPlace("Sydney port", 3));
        placest.add(addPlace("Sydney aquarium", 6));
        placest.add(addPlace("Purnululu National park", 2));

        addTown("Sydney", "Australia", places.size(), placest);


    }


    public WorldClass() {
        this.addAll();
    }

    public static WorldClass getInstance() {
        if (sInstance == null) {
            synchronized (WorldClass.class) {
                if (sInstance == null) {
                    sInstance = new WorldClass();
                }
            }
        }return sInstance;
    }
}
