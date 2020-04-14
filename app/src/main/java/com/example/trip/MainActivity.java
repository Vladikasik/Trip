package com.example.trip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.trip.Fragments.SettingFragment;
import com.example.trip.Fragments.TownsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private TextView mTextMessage;
    public BottomNavigationView navView;

    private TownsFragment townsFragment = new TownsFragment();
    private SettingFragment settingFragment = new SettingFragment();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Home");
                    changeFragment(townsFragment, false);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText("Settings");
                    //startActivity(new Intent(MainActivity.this, Settings.class));
                    changeFragment(settingFragment, false);
                    return true;
            }
            return false;
        }
    };

    private BottomNavigationView.OnNavigationItemReselectedListener mOnNavigationItemReselectedListener = new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            navView = findViewById(R.id.nav_view);
            mTextMessage = findViewById(R.id.message);
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            navView.setOnNavigationItemReselectedListener(mOnNavigationItemReselectedListener);

            getSupportFragmentManager().beginTransaction().add(R.id.place_holder, townsFragment).commit();
        }
    }

    public void changeFragment(Fragment fragment, boolean addToBack) {
        if (addToBack) {
            getSupportFragmentManager().beginTransaction().replace(R.id.place_holder, fragment).addToBackStack(fragment.getClass().getName()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.place_holder, fragment).commit();
        }
    }
}
