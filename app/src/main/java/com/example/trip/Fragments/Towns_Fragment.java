package com.example.trip.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trip.Adapters.TownsAdapter;
import com.example.trip.Data.Town;
import com.example.trip.Data.WorldClass;
import com.example.trip.R;

import java.util.ArrayList;
import java.util.List;

public class Towns_Fragment extends Fragment {

    TownsAdapter adapter;

    WorldClass worldClass = WorldClass.getInstance();

    List<Town> listTowns = worldClass.getTowns();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.town_fragment, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new TownsAdapter(getActivity(), (ArrayList<Town>) this.listTowns);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((ListView) getView().findViewById(R.id.town_list)).setAdapter(this.adapter);
    }

}
