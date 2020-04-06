package com.example.trip.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.trip.Data.Place;
import com.example.trip.Fragments.PlacesFragment;
import com.example.trip.MainActivity;
import com.example.trip.R;

import java.util.ArrayList;

public class EachPlaceAdapter {
    private Context mContext;

    public EachPlaceAdapter(Context context, ArrayList<Place> arr) {
        super(context, R.layout.place_item, arr);
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Place place = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.town_adapter_item, null);
        }

        ((TextView) convertView.findViewById(R.id.TownName)).setText(place.getName());
        ((TextView) convertView.findViewById(R.id.CountryName)).setText(Integer.toString(place.getCategory()));
        //((TextView) convertView.findViewById(R.id.NumOfPlaces)).setText(les.country);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext instanceof MainActivity) {
                    Bundle args = new Bundle();
                    args.putString("town", place.getName());
                    PlacesFragment ls = new PlacesFragment();
                    ls.setArguments(args);
                    ((MainActivity)mContext).changeFragment(ls, true);
                }
            }
        });

        return convertView;
    }
}
