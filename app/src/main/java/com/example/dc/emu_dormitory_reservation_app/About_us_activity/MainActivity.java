package com.example.dc.emu_dormitory_reservation_app.About_us_activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.app.ActionBarDrawerToggle;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Navigational_drawer.navigational_drawer;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;

public class MainActivity extends navigational_drawer {
//comment
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
          LayoutInflater inflater = (LayoutInflater) this
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View contentView = inflater.inflate(R.layout.activity_main, null, false);



        mToolbar.setTitle("About us");
        //toolbar.setSubtitle("welcome");
       mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.nav_back);
       mToolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                       // startActivity(new Intent(MainActivity.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activit
                    }
                } );


 mDrawer.addView(contentView, 0);


       // MyFun();

    }

}
