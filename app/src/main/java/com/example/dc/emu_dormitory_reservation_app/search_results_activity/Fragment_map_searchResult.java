package com.example.dc.emu_dormitory_reservation_app.search_results_activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dc.emu_dormitory_reservation_app.R;

public class Fragment_map_searchResult extends Fragment {
    private static final String TAG = "Fragment_map_searchResu";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: I am here map_search_result");
        View view = inflater.inflate(R.layout.fragment_mapview_search_result_activity, container, false);
        return view;
    }
}
