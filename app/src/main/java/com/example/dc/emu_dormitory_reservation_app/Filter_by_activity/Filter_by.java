package com.example.dc.emu_dormitory_reservation_app.Filter_by_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.emu_dormitory_reservation_app.FacilitiesFilterAdapter;
import com.example.dc.emu_dormitory_reservation_app.FilterByFacilitiesModel;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.SearchResultsListDataModel;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.search_result_activity;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Filter_by extends AppCompatActivity {
    TextView facilities, mpricemin, mpricemax;
    Button showResult;
    private CheckBox msone, mstwo, msthree, msfour, msfive, mprivatedorms, memudorms,mspring, mfall, msummer;
    private ExpandableLayout mfacilitie;
    private RequestQueue mQueue;
    private ArrayList<FilterByFacilitiesModel> facilitiesList = new ArrayList<>();
    private ArrayList<SearchResultsListDataModel> SearchfilteredDorms = new ArrayList<>();


    private FacilitiesFilterAdapter facilityadapter = new FacilitiesFilterAdapter();

    private ArrayList<String> star = new ArrayList<>();
    private ArrayList<String> profertytype = new ArrayList<>();
    private ArrayList<String> facilityId = new ArrayList<>();
    private ArrayList<String> checkInsemester = new ArrayList<>();
    private String priceMin="0", priceMMax="5000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_by);
        Toolbar toolbar = (Toolbar)findViewById(R.id.filter_by);
        toolbar.setTitle("Filter by");
        //toolbar.setSubtitle("welcome");




        /*star.add("1");
        star.add("3");
        star.add("4");
        profertytype.add("1");
        profertytype.add("0");
        facilityId.add("1");
        facilityId.add("3");
        facilityId.add("4");
        facilityId.add("5");
        checkInsemester.add("0");
        checkInsemester.add("1");
        checkInsemester.add("3");
        priceMin = "100";
        priceMMax = "400";*/

        facilityId.add("1");
        facilityId.add("3");
        facilityId.add("4");
        facilityId.add("5");

        facilityId.addAll(facilityadapter.getRfacilityId());


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



        //msone mstwo, msthree, msfour, msfive, mprivatedorms, memudorms,mspring, mfall, msummer

       /* msone = findViewById(R.id.isone);
        msone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "1";
                }
                else{
                    value = null;
                }

                star.add(value);
            }
        });
        mstwo = findViewById(R.id.istwo);
        mstwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "2";
                }
                else{
                    value = null;
                }

                star.add(value);
            }
        });

        msthree = findViewById(R.id.isthree);
        msthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "3";
                }
                else{
                    value = null;
                }

                star.add(value);
            }
        });

        msfour = findViewById(R.id.isfour);
        msfour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "4";
                }
                else{
                    value = null;
                }

                star.add(value);
            }
        });

        msfive = findViewById(R.id.isfive);
        msfive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "5";
                }
                else{
                    value = null;
                }

                star.add(value);
            }
        });

        mprivatedorms = findViewById(R.id.iprivatedorms);
        mprivatedorms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "1";
                }
                else{
                    value = null;
                }

                profertytype.add(value);
            }
        });

        memudorms = findViewById(R.id.iemudorms);
        memudorms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "2";
                }
                else{
                    value = null;
                }

                profertytype.add(value);
            }
        });

        mspring = findViewById(R.id.ispring);
        mspring.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "0";
                }
                else{
                    value = null;
                }

                profertytype.add(value);
            }
        });
        mfall = findViewById(R.id.ifall);
        mfall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "1";
                }
                else{
                    value = null;
                }

                profertytype.add(value);
            }
        });
        msummer = findViewById(R.id.isummer);
        msummer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String value;
                if (isChecked){
                    value = "1";
                }
                else{
                    value = null;
                }

                profertytype.add(value);
            }
        });*/


        MyFun();
        FilterFacilitiesAPI();




        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postFilterBooking();

                Intent i=new Intent(Filter_by.this,search_result_activity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("alldorms",SearchfilteredDorms);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    private void FilterFacilitiesAPI() {
        String url = "http://35.204.232.129/api/FacilitiesFilter";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            JSONObject JO = response.getJSONObject("body");

                            //for facilities images and names
                            JSONArray JA = JO.getJSONArray("facilities");

                            for (int i=0; i<JA.length(); i++){
                                JSONObject room = JA.getJSONObject(i);
                                String name = room.getString("facilityName");
                                String facilityId = room.getString("facilityId");


                                facilitiesList.add(new FilterByFacilitiesModel(name, facilityId));

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
        mpricemin = findViewById(R.id.ipricemin);
        mpricemax = findViewById(R.id.ipricemax);
        /*facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Filter_by.this,Facilities_filters.class));
            }
        });*/


        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(this);
        seekBar.setRangeValues(0, 5000);

        RangeSeekBar rangeSeekbar = (RangeSeekBar) findViewById(R.id.rangeSeekbar);
        rangeSeekbar.setNotifyWhileDragging(true);
        rangeSeekbar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {


                priceMin =  minValue.toString();
                priceMMax = maxValue.toString();

                mpricemin.setText("$"+ minValue.toString());
                mpricemax.setText("$"+maxValue.toString());

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

    public void postFilterBooking( ){
        // mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(Filter_by.this);
        StringRequest sr = new StringRequest(Request.Method.POST,"http://35.204.232.129/api/GetSearchDormitoriesByFilter", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //mPostCommentResponse.requestCompleted();


                try {

                    JSONObject responces = new JSONObject(response.toString());
                    JSONObject JO = responces.getJSONObject("body");

                    JSONArray JA = JO.getJSONArray("dormitories");


                    for (int i=0; i<JA.length(); i++){

                        JSONObject dormitories = JA.getJSONObject(i);
                        String picture = dormitories.getString("pictureUrl");
                        String DormitoryName = dormitories.getString("dormitoryName");
                        String dormdescription = dormitories.getString("dormitoryDescription");
                        String ratingnumber = dormitories.getString("ratingNumber");
                        String ratingtext = dormitories.getString("ratingText");
                        String DormitoryId = dormitories.getString("dormitoryId");

                        SearchfilteredDorms.add(new SearchResultsListDataModel(DormitoryName, dormdescription, ratingnumber, ratingtext, picture,DormitoryId));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mPostCommentResponse.requestEndedWithError(error);
            }
        }){
            @Override
            protected Map<String, String> getParams(){

                Map<String,String> params = new HashMap<String, String>();
                params.put("priceRangeMin", priceMin.toString()  /* "bsshdb"*/ );
                params.put("priceRangeMax", priceMMax.toString() /* "bsshdb"*/);
                params.put("starRating", String.valueOf(star)  /*"bsshdb"*/);
                params.put("propertyType", String.valueOf(profertytype)  /*"bsshdb"*/);
                params.put("facilitiesIds", String.valueOf(facilityId)  /* "bsshdb"*/);
                params.put("checkInSemester", String.valueOf(checkInsemester)  /*"bsshdb"*/);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }

    public void selectitem(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.isone:
                if (checked){
                    star.add("1");
                }
                else
                {
                    star.remove("1");
                }
                break;

            case R.id.istwo:
                if (checked){
                    star.add("2");
                }
                else
                {
                    star.remove("2");
                }
                break;

            case R.id.isthree:
                if (checked){
                    star.add("3");
                }
                else
                {
                    star.remove("3");
                }
                break;

            case R.id.isfour:
                if (checked){
                    star.add("4");
                }
                else
                {
                    star.remove("4");
                }
                break;

            case R.id.isfive:
                if (checked){
                    star.add("5");
                }
                else
                {
                    star.remove("5");
                }
                break;

            case R.id.iprivatedorms:
                if (checked){
                    profertytype.add("1");
                }
                else
                {
                    profertytype.remove("1");
                }
                break;

            case R.id.iemudorms:
                if (checked){
                    profertytype.add("2");
                }
                else
                {
                    profertytype.remove("2");
                }
                break;

            case R.id.ispring:
                if (checked){
                    checkInsemester.add("1");
                }
                else
                {
                    checkInsemester.remove("1");
                }
                break;

            case R.id.ifall:
                if (checked){
                    checkInsemester.add("2");
                }
                else
                {
                    checkInsemester.remove("2");
                }
                break;

            case R.id.isummer:
                if (checked){
                    checkInsemester.add("3");
                }
                else
                {
                    checkInsemester.remove("3");
                }
                break;

        }


    }
}
