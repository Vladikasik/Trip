package com.example.trip.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.trip.Adapters.PlacesAdapter;
import com.example.trip.Adapters.TownsAdapter;
import com.example.trip.Data.Place;
import com.example.trip.Data.Town;
import com.example.trip.Data.WorldClass;
import com.example.trip.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

import static android.content.Context.LOCATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;
import static java.security.AccessController.getContext;

public class PlacesFragment extends Fragment implements LocationListener {

    private String location_coor;

    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    String lat;
    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;

    PlacesAdapter adapter;

    WorldClass worldClass = WorldClass.getInstance();

    ArrayList<Town> list = worldClass.getTowns();

    private final Town townf;

    public PlacesFragment() throws IOException {
        townf = new Town();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (ContextCompat.checkSelfPermission(Objects.requireNonNull(getContext()), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager = (LocationManager) getContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            this.location_coor = loc.getLatitude() + ",+" + loc.getLongitude();
            System.out.println(this.location_coor);
        }else{
            ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity()), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 99);
        }

        LocationManager locationManager = (LocationManager) Objects.requireNonNull(getActivity()).getSystemService(LOCATION_SERVICE);
        assert locationManager != null;

        return inflater.inflate(R.layout.place_fragment, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list.forEach(new Consumer<Town>() {
            @Override
            public void accept(Town town) {
                String townFromArguments = getArguments().getString("town");
                String townFromLoop = town.getName();
                if (townFromLoop.equals(townFromArguments)) {
                    townf.setTown(town);
                    townf.printPlaces();
                }
            }
        });
        this.adapter = new PlacesAdapter(getActivity(), townf.getPlaces());
        ((ListView) getView().findViewById(R.id.listPlaces)).setAdapter(this.adapter);


        Button button = getView().findViewById(R.id.all_trip);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse(getTravel());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });

    }

    private String getTravel() {

        String finish = "https://www.google.com/maps/dir/?api=1&origin=" + this.location_coor + "&destination=" + this.location_coor + "&travelmode=walkingg&waypoints=";
        for (Place place : townf.getPlaces()) {
            finish = finish + place.ObjectCoordinates.replace(" ", "+") + "|";
        }
        finish = finish.replaceAll(".$", "");
        System.out.println(finish);


        return finish;
        }

    @Override
    public void onLocationChanged(Location location) {
        this.location_coor = location.getLatitude() + ", " + location.getLongitude();
        System.out.println(this.location_coor);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
