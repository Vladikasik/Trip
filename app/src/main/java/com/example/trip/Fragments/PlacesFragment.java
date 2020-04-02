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
import com.example.trip.Data.Town;
import com.example.trip.Data.WorldClass;
import com.example.trip.R;

import java.util.ArrayList;
import java.util.function.Consumer;

public class PlacesFragment extends Fragment {

    PlacesAdapter adapter;

    WorldClass worldClass = WorldClass.getInstance();

    ArrayList<Town> list = worldClass.getTowns();

    final Town townf;

    String townArg;

    private void getTown(ArrayList<Town> townsList){

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.town_fragment, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new PlacesAdapter(getActivity(), this.townf.getPlaces());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((ListView) getView().findViewById(R.id.town_list)).setAdapter(this.adapter);
    }

}
