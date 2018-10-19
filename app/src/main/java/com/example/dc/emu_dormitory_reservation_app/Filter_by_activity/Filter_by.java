package com.example.dc.emu_dormitory_reservation_app.Filter_by_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Facilities_filters;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class Filter_by extends AppCompatActivity {
    TextView facilities;
    Button showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_by);
        Toolbar toolbar = (Toolbar)findViewById(R.id.filter_by);
        toolbar.setTitle("Filter by");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Filter_by.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                     //   startActivity(new Intent(Filter_by.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );
        MyFun();
    }

    private void MyFun() {
        //there may be some bugs
        facilities=(TextView)findViewById(R.id.facilities_filter);
        showResult = (Button)findViewById(R.id.show_result);
        facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Filter_by.this,Facilities_filters.class));
            }
        });

        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(Filter_by.this,search_result.class));
            }
        });
        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(this);
        seekBar.setRangeValues(0, 5000);

        RangeSeekBar rangeSeekbar = (RangeSeekBar) findViewById(R.id.rangeSeekbar);
        rangeSeekbar.setNotifyWhileDragging(true);
        rangeSeekbar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {

                Toast.makeText(getApplicationContext(), "Min Value- " + minValue + " & " + "Max Value- " + maxValue, Toast.LENGTH_SHORT).show();
            }
        });

        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {


            }
        });

// Get noticed while dragging
        seekBar.setNotifyWhileDragging(true);
       // ((LinearLayout) findViewById(R.id.seekbarLayout)).addView(seekBar);



    }
}
