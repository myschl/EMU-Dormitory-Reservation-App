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

public class Fragment_list_searchResult extends Fragment{
    private static final String TAG = "Fragment_list_searchRes";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: I am here listSearchResults");
       View view = inflater.inflate(R.layout.fragment_listview_search_result_activity, container, false);
       return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: listSearchResult");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: listSearchResult");
    }
}
