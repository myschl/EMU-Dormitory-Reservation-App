package com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsActivity2;

import java.util.ArrayList;

public class rate_bookings_activity_1 extends AppCompatActivity {

    private static final String TAG = "rate_bookings_activity_";
    ArrayList<RateBookingsDataModel1> RateBookingsDataModel1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_bookings_1);
        Toolbar toolbar = (Toolbar)findViewById(R.id.rate_booking_toolbar1);
        toolbar.setTitle("Rate your stay");
        //toolbar.setSubtitle("welcome");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(rate_bookings_activity_1.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                       // startActivity(new Intent(rate_bookings_activity_1.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );
        initData();
        initRecycleViewCRateBookings1();

    }
    private void initData(){
        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Alfam dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "12"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Akdeniz dormitories",
                "B block 114",
                "27th July 2018",
                "4.8",
                "13"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "EMU 1 dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "14"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Sanel dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "15"));
        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Alfam dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "12"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Akdeniz dormitories",
                "B block 114",
                "27th July 2018",
                "4.8",
                "13"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "EMU 1 dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "14"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Sanel dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "15"));
        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Alfam dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "12"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Akdeniz dormitories",
                "B block 114",
                "27th July 2018",
                "4.8",
                "13"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "EMU 1 dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "14"));

        RateBookingsDataModel1.add( new RateBookingsDataModel1(
                "Sanel dormitories",
                "B block 114",
                "27th January 2018",
                "4.5",
                "15"));
    }

    private void initRecycleViewCRateBookings1(){
        Log.d(TAG, "initRecyclerView: Called");
        RecyclerView recycleViewRateBookings1 = findViewById(R.id.recycleViewRateBookings1);
        RateBookingsRecycleViewAdapter1 adapter = new RateBookingsRecycleViewAdapter1(this, RateBookingsDataModel1);
        recycleViewRateBookings1.setAdapter(adapter);
        recycleViewRateBookings1.setLayoutManager( new LinearLayoutManager(this));
    }
}
