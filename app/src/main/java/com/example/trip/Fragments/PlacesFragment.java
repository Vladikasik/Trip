package com.example.trip.Fragments;

import com.example.trip.Data.Town;
import com.example.trip.Data.WorldClass;

import java.util.ArrayList;

public class PlacesFragment extends PlacesFragment{

//    PlacesAdapter adapter;

    WorldClass worldClass = WorldClass.getInstance();

    ArrayList<Town> list = worldClass.getTowns();

    Town town;

    String townArg;

    private void getTown(ArrayList<Town> townsList){

        this.townArg = getArguments().getString("town");



    }

}
