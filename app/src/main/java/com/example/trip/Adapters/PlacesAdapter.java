package com.example.trip.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.trip.Data.Place;
import com.example.trip.Data.Town;
import com.example.trip.Fragments.EachPlaceFragment;
import com.example.trip.Fragments.PlacesFragment;
import com.example.trip.MainActivity;
import com.example.trip.R;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Place> {

    private Context mContext;

    public PlacesAdapter(Context context, ArrayList<Place> arr) {
        super(context, R.layout.town_adapter_item, arr);
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Place place = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.town_adapter_item, null);
        }

        ((TextView) convertView.findViewById(R.id.TownName)).setText(place.ObjectName);
        ((TextView) convertView.findViewById(R.id.CountryName)).setText(place.ObjectCategory);
        ((TextView) convertView.findViewById(R.id.text_country)).setText("Категория : ");
        convertView.findViewById(R.id.NumOfPlaces).setVisibility(View.GONE);
        convertView.findViewById(R.id.text_numofplaces).setVisibility(View.GONE);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext instanceof MainActivity) {
                    Bundle args = new Bundle();
                    args.putString("place", place.ObjectName+ "#" + place.ObjectCategory +"#" + place.ObjectInformation + "#" + place.ObjectCoordinates);
                    EachPlaceFragment ls = new EachPlaceFragment();
                    ls.setArguments(args);
                    ((MainActivity)mContext).changeFragment(ls, true);
                }
            }
        });

        return convertView;
    }
}
