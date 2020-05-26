package com.example.trip.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        final String[] args = getArguments().getString("place").split("#");

        //Place place = new Place(args[0], Integer. parseInt(args[1]) , args[2]);

        TextView title = getView().findViewById(R.id.Title);
        title.setText(args[0]);

        TextView info = getView().findViewById(R.id.Text);
        info.setText(args[2]);

        View convertView = getView();
        Button button = convertView.findViewById(R.id.go_map);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coordinates = args[3];
                System.out.println(coordinates);
                System.out.println(coordinates);
                Toast.makeText(getContext(), coordinates, Toast.LENGTH_LONG).show();
                String uri = "https://www.google.com/maps/search/?api=1&query=" + coordinates;
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(mapIntent);
            }
        });


    }
}
