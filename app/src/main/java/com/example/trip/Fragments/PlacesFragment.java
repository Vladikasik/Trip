package com.example.trip.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trip.Adapters.PlacesAdapter;
import com.example.trip.Adapters.TownsAdapter;
import com.example.trip.Data.Place;
import com.example.trip.Data.Town;
import com.example.trip.Data.WorldClass;
import com.example.trip.R;

import java.util.ArrayList;
import java.util.function.Consumer;

public class PlacesFragment extends Fragment {

    PlacesAdapter adapter;

    WorldClass worldClass = WorldClass.getInstance();

    ArrayList<Town> list = worldClass.getTowns();

    private final Town townf;

    public PlacesFragment(){
        townf = new Town();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.place_fragment, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list.forEach(new Consumer<Town>() {
            @Override
            public void accept(Town town) {
                if (town.getName() == getArguments().getString("town")) {
                    townf.setTown(town);
                }
            }
        });
        this.adapter = new PlacesAdapter(getActivity(), townf.getPlaces());
        ((ListView) getView().findViewById(R.id.listPlaces)).setAdapter(this.adapter);
    }
}
