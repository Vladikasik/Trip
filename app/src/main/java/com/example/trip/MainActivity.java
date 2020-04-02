package com.example.trip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private TextView mTextMessage;
    public BottomNavigationView navView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Home");
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText("Settings");
                    return true;
            }
            return false;
        }
    };

    private BottomNavigationView.OnNavigationItemReselectedListener mOnNavigationItemReselectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            navView = findViewById(R.id.nav_view);
            mTextMessage = findViewById(R.id.message);
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            navView.setOnNavigationItemReselectedListener(mOnNavigationItemReselectedListener);
        }
    }
}
