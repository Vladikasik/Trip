package com.example.trip.Data;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorldClass {

    private ArrayList<Town> towns = new ArrayList<>();
    private static WorldClass sInstance;

//    private Place addPlace(String namePlace, int category) {
//        String info = "This info will be updated";
//        Place place = new Place(namePlace, category, info);
//        return place;
//    }

    public ArrayList<Town> getTowns(){
        return this.towns;
    }
//
//    private void addTown(String nameTown, String country, int numOfPlaces, ArrayList<Place> places) {
//
//        Town town = new Town(nameTown, country, numOfPlaces);
//
//        town.addPlaces(places);
//
//        towns.add(town);
//    }
//
//    private void addAll() {
//
//        ArrayList<Place> places = new ArrayList<>();
//
//        places.add(addPlace("The Red Square", 0));
//        places.add(addPlace("Novodevichy Convent", 666));
//        places.add(addPlace("Planetarium", 6));
//        places.add(addPlace("Peredelkino", 666));
//
//        addTown("Moscow", "Russia", places.size(), places);
//
//        ArrayList<Place> placest = new ArrayList<>();
//
//        placest.add(addPlace("Sydney jopera", 5));
//        placest.add(addPlace("Sydney port", 3));
//        placest.add(addPlace("Sydney aquarium", 6));
//        placest.add(addPlace("Purnululu National park", 2));
//
//        addTown("Sydney", "Australia", places.size(), placest);
//
//
//    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        //здесь мы можем использовать разделитель, например: "\\A", "\\Z" или "\\z"
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }

    private void readJson() throws IOException {
        String fileName = "/data/data/com.example.trip/files/places.json";

        String jsonString = readUsingScanner(fileName);

        System.out.println("program started");
        Gson g = new Gson();
        Place[] listall = g.fromJson(jsonString, Place[].class);
        List<String> towns = new ArrayList<String>();
        ArrayList<Town> townslist = new ArrayList<Town>();

        for (Place place : listall){
            String townname = place.ObjectTown;
            if (towns.indexOf(townname) != -1){
                for (Town town : townslist){
                    if (townname.equals(town.getName())){
                        town.addPlace(place);
                        System.out.println("yohooo");
                    }
                }
            }else{
                towns.add(townname);
                Town town = new Town(place.ObjectTown, place.ObjectCountry);
                town.addPlace(place);
                townslist.add(town);
            }
        }

        this.towns = townslist;

    }

    public WorldClass() throws IOException {
        this.readJson();
    }

    public static WorldClass getInstance() throws IOException {
        if (sInstance == null) {
            synchronized (WorldClass.class) {
                if (sInstance == null) {
                    sInstance = new WorldClass();
                }
            }
        }return sInstance;
    }
}
