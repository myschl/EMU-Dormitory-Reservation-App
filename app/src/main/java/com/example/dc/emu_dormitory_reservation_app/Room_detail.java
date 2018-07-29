package com.example.dc.emu_dormitory_reservation_app;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Room_detail extends AppCompatActivity {
    ViewPager viewPager;
    int images[] = {R.drawable.akdeniz_1, R.drawable.akdeniz_2, R.drawable.akdeniz_3, R.drawable.akdeniz_2};
    MyCustomPagerAdapter myCustomPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        Toolbar toolbar = (Toolbar)findViewById(R.id.room_detail);
        toolbar.setTitle("Room");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        Myfun();
    }

    private void Myfun() {
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(Room_detail.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
    }
}
