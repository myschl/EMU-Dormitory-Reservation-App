package com.example.dc.emu_dormitory_reservation_app.Filter_by_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.DormitoryDetailFacilityAdapter;
import com.example.dc.emu_dormitory_reservation_app.Dormitory_detail;
import com.example.dc.emu_dormitory_reservation_app.FacilitiesFilterAdapter;
import com.example.dc.emu_dormitory_reservation_app.Facilities_filters;
import com.example.dc.emu_dormitory_reservation_app.FilterByFacilitiesModel;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.RoomDetailImageModel;
import com.example.dc.emu_dormitory_reservation_app.RoomDetailModel1;
import com.example.dc.emu_dormitory_reservation_app.Room_detail;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Filter_by extends AppCompatActivity {
    TextView facilities;
    Button showResult;
    private ExpandableLayout mfacilitie;
    private RequestQueue mQueue;
    private ArrayList<FilterByFacilitiesModel> facilitiesList = new ArrayList<>();

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
        FilterFacilitiesAPI();
    }

    private void FilterFacilitiesAPI() {
        String url = "http://35.204.232.129/api/FacilitiesFilter";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            JSONObject JO = response.getJSONObject("Body");

                            //for facilities images and names
                            JSONArray JA = JO.getJSONArray("Facilities");

                            for (int i=0; i<JA.length(); i++){
                                JSONObject room = JA.getJSONObject(i);
                                String name = room.getString("facilityname");
                                String facilityId = room.getString("facilityId");


                                facilitiesList.add(new FilterByFacilitiesModel(name));

                                //mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(DormitoryName, Deals, picture));

                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue = Volley.newRequestQueue(Filter_by.this);
        mQueue.add(request);

    }

    private void MyFun() {
        //there may be some bugs
        //facilities=(TextView)findViewById(R.id.facilities_filter);
        showResult = (Button)findViewById(R.id.ishow_result);
        /*facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Filter_by.this,Facilities_filters.class));
            }
        });*/

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

                //Toast.makeText(getApplicationContext(), "Min Value- " + minValue + " & " + "Max Value- " + maxValue, Toast.LENGTH_SHORT).show();
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

    public void FacilitiesFilter(View view) {

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.ifacilitiesrecycleview);
        FacilitiesFilterAdapter adapter = new FacilitiesFilterAdapter(Filter_by.this, facilitiesList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager verticalLayoutManagaer = new LinearLayoutManager(Filter_by.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManagaer);

        mfacilitie = findViewById(R.id.ifacilities);
        mfacilitie.toggle();
    }
}
