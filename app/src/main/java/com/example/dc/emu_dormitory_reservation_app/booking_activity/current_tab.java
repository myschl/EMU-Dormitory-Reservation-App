package com.example.dc.emu_dormitory_reservation_app.booking_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsRecycleViewAdapter2;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class current_tab extends Fragment {
    private Context mContext;

    private ArrayList<bookingsDataModel> mBookingsDataModel = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_current_booking_tabbed_activity, container, false);

        mContext = getContext();
        dataInit();
        initRecycleView(rootView);
        return rootView;
    }

    private void dataInit(){
        Log.d(TAG, "dataInit: ");
        mBookingsDataModel.add(new bookingsDataModel(
                "Alfam dormitories",
                "Alfam dormitories has four bloc...",
                "27 August 2019",
                "19 August 2018",
                "Pending",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/1.jpg"));

        mBookingsDataModel.add(new bookingsDataModel(
                "Alfam dormitories",
                "Alfam dormitories has four bloc...",
                "27 August 2019",
                "19 August 2018",
                "Pending",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));

        mBookingsDataModel.add(new bookingsDataModel(
                "Alfam dormitories",
                "Alfam dormitories has four bloc...",
                "27 August 2019",
                "19 August 2018",
                "Pending",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/4.jpg"));


    }
    private void initRecycleView(View v){
        Log.d(TAG, "initRecyclerView: Called");
        RecyclerView recycleView = v.findViewById(R.id.recycleViewCurrentBooking);
        bookingRecycleViewAdapter adapter = new bookingRecycleViewAdapter  (mContext, mBookingsDataModel);
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager( new LinearLayoutManager(mContext));
    }
}