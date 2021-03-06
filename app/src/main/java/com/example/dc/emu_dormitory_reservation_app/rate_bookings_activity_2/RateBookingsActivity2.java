package com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2;

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
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_1.RateBookingsDataModel1;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_1.RateBookingsRecycleViewAdapter1;
import com.example.dc.emu_dormitory_reservation_app.rate_your_stay_activity.Rate_your_stay;

import java.util.ArrayList;

public class RateBookingsActivity2 extends AppCompatActivity {
    private static final String TAG = "RateBookingsActivity2";
    ArrayList<RateBookingsDataModel2> RateBookingsDataModel2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_bookings2);
        Toolbar toolbar = (Toolbar)findViewById(R.id.rate_booking_toolbar2);
        toolbar.setTitle("Rate your stay");
        //toolbar.setSubtitle("welcome");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RateBookingsActivity2.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        //startActivity(new Intent(RateBookingsActivity2.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );
        initData();
        initRecycleViewCRateBookings1();
    }


    private void initData(){
        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/6.jpg",
                "23"
                ));

        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/1.jpg",
                "23"
                ));
        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg",
                "23"
                ));


        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/ugursal/IMG_1220.JPG?RenditionID=3",
                "23"
                ));


        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg",
                "23"
                ));
        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/6.jpg",
                "23"
                ));

        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/1.jpg",
                "23"
                ));
        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg",
                "23"
                ));


        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/ugursal/IMG_1220.JPG?RenditionID=3",
                "23"
                ));


        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg",
                "23"
                ));
        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/6.jpg",
                "23"
                ));

        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/1.jpg",
                "23"
                ));
        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg",
                "23"
                ));


        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/ugursal/IMG_1220.JPG?RenditionID=3",
                "23"
                ));


        RateBookingsDataModel2.add(new RateBookingsDataModel2(
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg",
                "23"
                ));


    }


    private void initRecycleViewCRateBookings1(){
        Log.d(TAG, "initRecyclerView: Called");
        RecyclerView recycleViewRateBookings2 = findViewById(R.id.recycleViewRateBookings2);
        RateBookingsRecycleViewAdapter2 adapter = new RateBookingsRecycleViewAdapter2(this, RateBookingsDataModel2);
        recycleViewRateBookings2.setAdapter(adapter);
        recycleViewRateBookings2.setLayoutManager( new LinearLayoutManager(this));
    }
}
