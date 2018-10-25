package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.Filter_by_activity.Filter_by;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;

public class Facilities_filters extends AppCompatActivity {
    private Button mdone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_filters);
        Toolbar toolbar = (Toolbar)findViewById(R.id.filter);
        toolbar.setTitle("Filters");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Facilities_filters.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        mdone = findViewById(R.id.idone);
        mdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Facilities_filters.this, Filter_by.class));
                finish();
            }
        });
    }

    /*@Override
    public void onClick(View v) {
        if (v == mdone){
            // finish the activity
            finish();
            startActivity(new Intent(this, Filter_by.class));

        }

    }*/
}
