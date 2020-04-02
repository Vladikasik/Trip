package com.example.trip.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.trip.Data.Place;
import com.example.trip.Data.Town;
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

        // TODO Implement view setup and view itself in town_adapter_item.xml

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("town", place.getName());
            }
        });


        return convertView;
    }
}
