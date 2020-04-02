package com.example.trip.Data;

import java.util.ArrayList;
import java.util.List;

public class WorldClass {

    private List<Town> towns = new ArrayList<>();
    private static WorldClass sInstance;

    private Place addPlace(String namePlace, int category) {
        Place place = new Place(namePlace, category);
        return place;
    }

    public List<Town> getTowns(){
        return this.towns;
    }

    private void addTown(String nameTown, String country, int numOfPlaces, List<Place> places) {

        Town town = new Town(nameTown, country, numOfPlaces);

        town.addPlaces(places);

        towns.add(town);
    }

    private void addAll() {

        List<Place> places = new ArrayList<>();

        places.add(addPlace("The Red Square", 0));
        places.add(addPlace("Novodevichy Convent", 666));
        places.add(addPlace("Planetarium", 6));
        places.add(addPlace("Peredelkino", 666));

        addTown("Moscow", "Russia", places.size(), places);

        places.clear();

        places.add(addPlace("Sydney jopera", 5));
        places.add(addPlace("Sydney port", 3));
        places.add(addPlace("Sydney aquarium", 6));
        places.add(addPlace("Purnululu National park", 2));

        addTown("Sydney", "Australia", places.size(), places);


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
