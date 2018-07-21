package com.example.dc.emu_dormitory_reservation_app.Home_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.edit_booking_activity.Edit_booking;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsRecycleViewAdapter2;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private ArrayList<HomeActivityDataModel> mHomeActivityDataModelsPopularDorms = new ArrayList<>();
    private ArrayList<HomeActivityDataModel> mHomeActivityDataModelsHighestRatedDorms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar)findViewById(R.id.home_activity_toolbar);
        toolbar.setTitle("Home");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_light);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(HomeActivity.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Edit_booking.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        initData();
        initRecycleViewHigestRatedDorms();
        initRecycleViewPopularDorms();
    }

    private void initData(){
mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));

mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));

mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));



    }




    private void initRecycleViewPopularDorms(){
        Log.d(TAG, "initRecyclerView: called");
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycleViewPopularDormitories);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new HomeActivityRecycleViewAdapter(this, mHomeActivityDataModelsPopularDorms));
    }

    private void initRecycleViewHigestRatedDorms(){
        Log.d(TAG, "initRecyclerView: called");
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycleViewHigestRatedDormitories);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new HomeActivityRecycleViewAdapter(this, mHomeActivityDataModelsHighestRatedDorms));
    }
}
