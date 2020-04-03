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

import com.example.trip.Data.Town;
import com.example.trip.Fragments.PlacesFragment;
import com.example.trip.MainActivity;
import com.example.trip.R;

import java.util.ArrayList;

public class TownsAdapter extends ArrayAdapter<Town> {
    private Context mContext;

    public TownsAdapter(Context context, ArrayList<Town> arr) {
        super(context, R.layout.town_adapter_item, arr);
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Town town = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.town_adapter_item, null);
        }

        // TODO Implement view setup and view itself in town_adapter_item.xml
        ((TextView) convertView.findViewById(R.id.TownName)).setText(town.getName());
        ((TextView) convertView.findViewById(R.id.CountryName)).setText(town.getCountry());
        ((TextView) convertView.findViewById(R.id.NumOfPlaces)).setText(Integer.toString(town.getNumOfPlaces()));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("town", town.getName());
                PlacesFragment pf = new PlacesFragment();
                pf.setArguments(args);
                ((MainActivity) mContext).changeFragment(pf, true);
            }
        });


        return convertView;
    }
}
