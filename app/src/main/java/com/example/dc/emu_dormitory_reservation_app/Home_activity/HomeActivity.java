package com.example.dc.emu_dormitory_reservation_app.Home_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.dc.emu_dormitory_reservation_app.Navigational_drawer.navigational_drawer;

import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.edit_booking_activity.Edit_booking;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsRecycleViewAdapter2;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.Fragment_list_searchResult;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.SearchResultsListDataModel;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.search_result_activity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity  extends navigational_drawer {
    private static final String TAG = "HomeActivity";

    private TextView mwelcom;
    private FirebaseAuth firebaseAuth;
    private RequestQueue mQueue;
    private Button msearch;
    private TextView mdormname ,dormtype;
    private ArrayList<SearchResultsListDataModel> SearchAllDorms = new ArrayList<>();


    private ArrayList<HomeActivityDataModel> mHomeActivityDataModelsPopularDorms = new ArrayList<>();
    private ArrayList<HomeActivityDataModel> mHomeActivityDataModelsHighestRatedDorms = new ArrayList<>();

   /* public HomeActivity() {
    }*/

   /* @Override
    protected void onStart() {
        super.onStart();
        if (firebaseAuth.getCurrentUser() != null){
              firebaseAuth = FirebaseAuth.getInstance();
              FirebaseUser user = firebaseAuth.getCurrentUser();

               //Glide.with(this)
               mwelcom = (TextView)findViewById(R.id.iwelcome);
               mwelcom.setText("Hi "+user.getEmail());
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



       /* firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        mwelcom = (TextView)findViewById(R.id.iwelcome);
        mwelcom.setText("Hi "+user.getEmail());*/


      //  setContentView(R.layout.activity_home);
         android.view.LayoutInflater inflater = (android.view.LayoutInflater) this
            .getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
    View contentView = inflater.inflate(R.layout.activity_home, null, false);


        msearch =(Button) contentView.findViewById(R.id.BtnSearch);
        Log.d(TAG, "onCreate: Assigned msearch");
        mdormname = contentView.findViewById(R.id.idormname);
        dormtype = contentView.findViewById(R.id.idormtype);


        msearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: entered on click button");

                    Intent i=new Intent(HomeActivity.this,search_result_activity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("alldorms",SearchAllDorms);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            });
    //    Toolbar toolbar = (Toolbar)findViewById(R.id.home_activity_toolbar);
      //  mToolbar.setTitle("Home");
        //toolbar.setSubtitle("welcome");
     //   setSupportActionBar(mToolbar);
       // mToolbar.setNavigationIcon(R.drawable.ic_menu_light);
     /*   mToolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(HomeActivity.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Edit_booking.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );*/

        initData();
        initRecycleViewHigestRatedDorms(contentView);
        initRecycleViewPopularDorms(contentView);

        //api functions call
        HighratedDorms();
        PopulaDorms();
        AllDormitoriesSearchAPI();


         mDrawer.addView(contentView, 0);
    }

    private void AllDormitoriesSearchAPI() {
        Log.d(TAG, "SearchAllDorms: Entered searchAllDorms function");
        String url = "http://35.204.232.129/api/GetDormitories";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: Json resonse returned");
                        Log.d(TAG, "onResponse: response is"+ response);

                        try {
                            Log.d(TAG, "onResponse: Entered try");
                            JSONObject JO = response.getJSONObject("Body");

                            Log.d(TAG, "onResponse: assigned response to JSonObject");
                            JSONArray JA = JO.getJSONArray("Dormitories");

                            Log.d(TAG, "onResponse: JsonArray assignment");

                            for (int i=0; i<JA.length(); i++){

                                JSONObject dormitories = JA.getJSONObject(i);
                                Log.d(TAG, "onResponse: looping, after jsonOnject");
                                String picture = dormitories.getString("PictureUrl");
                                String DormitoryName = dormitories.getString("DormitoryName");
                                String dormdescription = dormitories.getString("DormitoryDescription");
                                String ratingnumber = dormitories.getString("RatingNumber");
                                String ratingtext = dormitories.getString("RatingText");
                                String DormitoriTd = dormitories.getString("DormitoryId");

                                SearchAllDorms.add(new SearchResultsListDataModel(DormitoryName, dormdescription, ratingnumber, ratingtext, picture,DormitoriTd));
                                Log.d(TAG, "onResponse: Add to the SearchAllDorm array");
                            }

                        } catch (JSONException e) {
                            Log.d(TAG, "onResponse: Throwed JSON Exception error");
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Log.d(TAG, "SearchAllDorms: About to assign to mQueue");
        mQueue = Volley.newRequestQueue(HomeActivity.this);

        Log.d(TAG, "SearchAllDorms: mQueue assignment successfull");
        mQueue.add(request);

        Log.d(TAG, "SearchAllDorms: Adding requuest to the queue");
    }

 /*   private void SearchAllDorms(){

        Log.d(TAG, "SearchAllDorms: About to enter intent");
        Intent i=new Intent(HomeActivity.this,search_result_activity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("alldorms",SearchAllDorms);
        i.putExtras(bundle);
        startActivity(i);

        Log.d(TAG, "SearchAllDorms: Intent successfull");
    }*/

    private void HighratedDorms() {
        String url = "http://35.204.232.129/api/GetHighlyRatedDormitories";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("Body");

                            JSONArray JA = JO.getJSONArray("Dormitories");

                            for (int i=0; i<JA.length(); i++){
                                JSONObject booking = JA.getJSONObject(i);
                                String picture = booking.getString("PictureUrl");
                                String DormitoryName = booking.getString("DormitoryName");
                                String Deals = booking.getString("DealsText");
                                String DormitoriTd = booking.getString("DormitoryId");

                                mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(DormitoryName, Deals, 3, "$", true, picture));
                               // mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(DormitoryName, Deals, picture));
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
        mQueue = Volley.newRequestQueue(HomeActivity.this);
        mQueue.add(request);
    }

    private void PopulaDorms() {
        String url = "http://35.204.232.129/api/GetMostPopularDormitories";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("Body");

                            JSONArray JA = JO.getJSONArray("Dormitories");

                            for (int i=0; i<JA.length(); i++){
                                JSONObject booking = JA.getJSONObject(i);
                                String picture = booking.getString("PictureUrl");
                                String DormitoryName = booking.getString("DormitoryName");
                                String Deals = booking.getString("DealsText");
                                String DormitoriTd = booking.getString("DormitoryId");

                                mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(DormitoryName, Deals, 3, "$", true, picture));

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
        mQueue = Volley.newRequestQueue(HomeActivity.this);
        mQueue.add(request);
    }


    private void initData(){
/*mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));

mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));*/

/*mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));


mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(
        "Alfam Dormitories",
        "Deals start at",
        3,
        "$", true,
        "https://dormitories.emu.edu.tr/PublishingImages/Dormitories/alfam/9.jpg"));*/



    }




    private void initRecycleViewPopularDorms(View view){
        Log.d(TAG, "initRecyclerView: called");
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewPopularDormitories);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new HomeActivityRecycleViewAdapter(this, mHomeActivityDataModelsPopularDorms));
    }

    private void initRecycleViewHigestRatedDorms(View view){
        Log.d(TAG, "initRecyclerView: called");
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewHigestRatedDormitories);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new HomeActivityRecycleViewAdapter(this, mHomeActivityDataModelsHighestRatedDorms));
    }
}
