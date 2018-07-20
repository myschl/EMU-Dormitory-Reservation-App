package com.example.dc.emu_dormitory_reservation_app.search_results_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SearchResultFragmentStatePagerAdapter  extends FragmentStatePagerAdapter{
    private static final String TAG = "SearchResultFragmentSta";
   private final List<Fragment> mFragmentList = new ArrayList<>();
   private final List<String> mFragmentTitleList = new ArrayList<>();


    public SearchResultFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title){
        Log.d(TAG, "addFragment: I am here adapter");
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: I am here adapter position: "+position);
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: adapter "+mFragmentList.size());

        return mFragmentList.size();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Log.d(TAG, "notifyDataSetChanged: ");
    }
}
