package com.example.dc.emu_dormitory_reservation_app.search_results_activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.Filter_by_activity.Filter_by;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.edit_booking_activity.Edit_booking;

import java.util.ArrayList;

public class search_result_activity extends AppCompatActivity {
    private static final String TAG = "search_result_activity";
    private Boolean toggle= false;
    private SearchResultFragmentStatePagerAdapter mSearchResultFragmentStatePagerAdapter;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_activity);
        Log.d(TAG, "onCreate: searchActivity start");
        final TextView textViewList;
        final ImageView imageViewListIcon;
         textViewList = findViewById(R.id.textViewList);
         imageViewListIcon = findViewById(R.id.imageViewListIcon);
        RelativeLayout relativeLayoutSortSearchResult,relativeLayoutFilterSearchResult,relativeLayoutListSearchResult;
        relativeLayoutSortSearchResult = findViewById(R.id.relativeLayoutSortSearchResult);
        relativeLayoutFilterSearchResult = findViewById(R.id.relativeLayoutFilterSearchResult);
        relativeLayoutListSearchResult = findViewById(R.id.relativeLayoutListSearchResult);



        // sssssssssssswwwwwwww
    /*    Bundle bundleobje=getIntent().getExtras();
        ArrayList AllDorms =(ArrayList<SearchResultsListDataModel>)
                bundleobje.getSerializable("alldorms");*/




        relativeLayoutFilterSearchResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(search_result_activity.this, "I have been summoned Filter", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(search_result_activity.this,Filter_by.class));
            }
        });

        relativeLayoutListSearchResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(search_result_activity.this, "I have been summoned List", Toast.LENGTH_SHORT).show();

                if(toggle){
                imageViewListIcon.setImageResource(R.drawable.ic_map);
                textViewList.setText("MAP");
                toggle=false;
                setmViewPager(0);
                }
                else {
                    imageViewListIcon.setImageResource(R.drawable.ic_list);
                    textViewList.setText("List");
                    toggle=true;
                    setmViewPager(1);
                }
                }

        });

        relativeLayoutSortSearchResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(search_result_activity.this, "I have been summoned Sort", Toast.LENGTH_SHORT).show();
            }
        });



        Toolbar toolbar = (Toolbar)findViewById(R.id.search_result_toolbar);
        toolbar.setTitle("Search results");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(search_result_activity.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Edit_booking.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                });
        mSearchResultFragmentStatePagerAdapter = new SearchResultFragmentStatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.fragmentContainerSearchResults);
        //setup the pager

        setupViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager){
        Log.d(TAG, "setupViewPager: I am here");
        SearchResultFragmentStatePagerAdapter adapter = new SearchResultFragmentStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_list_searchResult(), "list_search_result");
        adapter.addFragment(new Fragment_map_searchResult(), "map_search_result");
        viewPager.setAdapter(adapter);
    }

    public void setmViewPager(int fragmentNumber){
        Log.d(TAG, "setmViewPager: I am here");
        mViewPager.setCurrentItem(fragmentNumber);
    }
}
