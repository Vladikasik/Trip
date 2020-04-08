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
import com.example.trip.Fragments.PlacesFragment;
import com.example.trip.MainActivity;
import com.example.trip.R;

import java.util.ArrayList;
import java.util.List;

public class EachPlaceAdapter extends ArrayAdapter<Place> {
    private Context mContext;
    private Place place;
    public EachPlaceAdapter(Context context, Place place) {
        super(context, R.layout.place_item, (List<Place>) place);
        this.mContext = context;
        this.place = place;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.place_item, null);
        }

        ((TextView) convertView.findViewById(R.id.Title)).setText(this.place.getName());
        ((TextView) convertView.findViewById(R.id.Text)).setText(this.place.getInfo());

        return convertView;
    }
}
