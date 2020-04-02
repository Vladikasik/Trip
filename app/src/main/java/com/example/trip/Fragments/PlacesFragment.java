package com.example.trip.Fragments;

import androidx.fragment.app.Fragment;

import com.example.trip.Adapters.PlacesAdapter;
import com.example.trip.Data.Town;
import com.example.trip.Data.WorldClass;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {

    PlacesAdapter adapter;

    WorldClass worldClass = WorldClass.getInstance();

    ArrayList<Town> list = worldClass.getTowns();

    Town town;

    String townArg;

    private void getTown(ArrayList<Town> townsList){

        this.townArg = getArguments().getString("town");



    }

}
