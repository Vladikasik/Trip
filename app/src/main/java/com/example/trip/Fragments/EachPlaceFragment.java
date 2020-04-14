package com.example.trip.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trip.Adapters.EachPlaceAdapter;
import com.example.trip.Data.Place;
import com.example.trip.Data.Town;
import com.example.trip.R;

import java.util.function.Consumer;

public class EachPlaceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.place_item, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] args = getArguments().getString("place").split("#");

        //Place place = new Place(args[0], Integer. parseInt(args[1]) , args[2]);

        TextView title = getView().findViewById(R.id.Title);
        title.setText(args[0]);

        TextView info = getView().findViewById(R.id.Text);
        info.setText(args[2]);
    }
}
