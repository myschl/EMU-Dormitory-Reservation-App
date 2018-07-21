package com.example.dc.emu_dormitory_reservation_app.search_results_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsDataModel2;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsRecycleViewAdapter2;

import java.util.ArrayList;

public class Fragment_list_searchResult extends Fragment{
    private static final String TAG = "Fragment_list_searchRes";
    Context mContext;
    ArrayList<SearchResultsListDataModel> mSearchResultsListDataModels = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: I am here listSearchResults");
       View view = inflater.inflate(R.layout.fragment_listview_search_result_activity, container, false);

        mContext = getContext();
        dataInit();
        initRecycleView(view);
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

    private void dataInit(){
        mSearchResultsListDataModels.add(new SearchResultsListDataModel (
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/6.jpg",
                "23"
        ));
        mSearchResultsListDataModels.add(new SearchResultsListDataModel (
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/6.jpg",
                "23"
        ));
        mSearchResultsListDataModels.add(new SearchResultsListDataModel (
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/6.jpg",
                "23"
        ));
        mSearchResultsListDataModels.add(new SearchResultsListDataModel (
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/6.jpg",
                "23"
        ));
        mSearchResultsListDataModels.add(new SearchResultsListDataModel (
                "Alfam Dormitories",
                "Alfam dormitories has four blocks seperate.....",
                "4.5",
                "Very Good",
                "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/6.jpg",
                "23"
        ));




    }


    private void initRecycleView(View v){
        Log.d(TAG, "initRecyclerView: Called");
        RecyclerView recycleViewFragment_list_search_result = v.findViewById(R.id.recycleViewSearchResultsList);
       SearchResultsListRecycleViewAdapter adapter = new SearchResultsListRecycleViewAdapter(mContext, mSearchResultsListDataModels);
        recycleViewFragment_list_search_result.setAdapter(adapter);
        recycleViewFragment_list_search_result.setLayoutManager( new LinearLayoutManager(mContext));
    }
}
