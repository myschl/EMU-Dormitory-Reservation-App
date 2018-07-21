package com.example.dc.emu_dormitory_reservation_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Facilities_filters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_filters);
        Toolbar toolbar = (Toolbar)findViewById(R.id.filter);
        toolbar.setTitle("Filters");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        //toolbar.setNavigationIcon(R.drawable.nav_back);
    }
}
