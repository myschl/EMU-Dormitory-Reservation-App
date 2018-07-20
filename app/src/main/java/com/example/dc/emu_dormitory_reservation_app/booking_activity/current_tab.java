package com.example.dc.emu_dormitory_reservation_app.booking_activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dc.emu_dormitory_reservation_app.R;

public class current_tab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_current_booking_tabbed_activity, container, false);

        return rootView;
    }
}