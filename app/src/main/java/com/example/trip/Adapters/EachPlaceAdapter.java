package com.example.trip.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        ((TextView) convertView.findViewById(R.id.Title)).setText(this.place.ObjectName);
        ((TextView) convertView.findViewById(R.id.Text)).setText(this.place.ObjectInformation);
        Button button = convertView.findViewById(R.id.go_map);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("keeeeeeeeeeeeek");
                openOnMap();
            }
        });

        return convertView;
    }


    private void openOnMap(){
        String coordinates = place.ObjectCoordinates;
        System.out.println(coordinates);
        Toast.makeText(getContext(), coordinates, Toast.LENGTH_LONG).show();
        String regex = " ";
        String coor[] = coordinates.split(" ");
        String uri = "geo:"+coor[0] + "," + coor[1];
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
        mContext.startActivity(mapIntent);
    }
}
