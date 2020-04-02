package com.example.trip.Fragments;

import androidx.fragment.app.Fragment;

import com.example.trip.Adapters.PlacesAdapter;
import com.example.trip.Data.Town;
import com.example.trip.Data.WorldClass;

import java.util.ArrayList;
import java.util.function.Consumer;

public class PlacesFragment extends Fragment {

    PlacesAdapter adapter;

    WorldClass worldClass = WorldClass.getInstance();

    ArrayList<Town> list = worldClass.getTowns();

    final Town townf;

    String townArg;

    private Town getTown(ArrayList<Town> townsList){

        this.townArg = getArguments().getString("town");

        final String name = getArguments().getString("town");

        townsList.forEach(new Consumer<Town>() {
            @Override
            public void accept(Town town) {
                if (town.getName() == name) {
                    townf.setTown(town);
                }
            }
        });
    }

}
