package com.example.dc.emu_dormitory_reservation_app.Home_activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.dc.emu_dormitory_reservation_app.Dormitory_detail;
import com.example.dc.emu_dormitory_reservation_app.Navigational_drawer.navigational_drawer;

import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.edit_booking_activity.Edit_booking;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsRecycleViewAdapter2;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.Fragment_list_searchResult;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.SearchResultsListDataModel;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.search_result_activity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    private DatabaseReference DR;
    private FirebaseUser user;
    private String uid;

    private RequestQueue mQueue;
    private Button msearch;
    private TextView mdormname ,dormtype;
    private ArrayList<SearchResultsListDataModel> SearchAllDorms = new ArrayList<>();
    private Spinner msdormname;
    private Spinner msdormtype;
    ArrayAdapter<String> Adapter1, Adapter2;
    private String dormid;
    String[] dormitoriesName = {"Search all Dormitories","Akdeniz dormitory","Alfam  dormitory","Ozuk dormitory","pop Art dormitory","Long son dormitory","EMU1 dormitory","EMU2  dormitory","EMU3 dormitory"," EMU4 dormitory"," Sabanci dormitory"};
    String[] dormitorytype = {"all Dormitory type ", "EMU dormitory", "Private own dormitory"};
    String[] privatedormitoriesName = {"Search all Dormitories","Akdeniz dormitory","Alfam  dormitory","Ozuk dormitory","pop Art dormitory","Long son dormitory"};
    String[] EMUdormitoriesName = {"Search all Dormitories","EMU1 dormitory","EMU2  dormitory","EMU3 dormitory"," EMU4 dormitory"," Sabanci dormitory"};

    ArrayAdapter<String> adapter;
    private String DormitoryType = "0";


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






       /* FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();

            DR = FirebaseDatabase.getInstance().getReference().child("Users");
            DR.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String name = dataSnapshot.child(uid).child("name").getValue(String.class);
                    mwelcom.setText(name);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(HomeActivity.this, "Network Error", Toast.LENGTH_SHORT).show();

                }
            });
        }*/






        //final String[] dormitoriesName = getResources().getStringArray(R.array.Dormitories);

         /*String[] dormitoriesName = {"Searc all Dormitories","Akdeniz dormitory","Alfam Akdeniz dormitory","Ozuk Akdeniz dormitory","pop Art Akdeniz dormitory","Long son Akdeniz dormitory"};
         String[] dormitorytype = {"all Dormitory type ", "EMU dormitory", "Private own dormitory"};*/

       /* firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        mwelcom = (TextView)findViewById(R.id.iwelcome);
        mwelcom.setText("Hi "+user.getEmail());*/


      //  setContentView(R.layout.activity_home);
         android.view.LayoutInflater inflater = (android.view.LayoutInflater) this
            .getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
    View contentView = inflater.inflate(R.layout.activity_home, null, false);


        msearch =(Button) contentView.findViewById(R.id.BtnSearch);

        mwelcom = contentView.findViewById(R.id.iwelcome);
        Log.d(TAG, "onCreate: Assigned msearch");
        /*mdormname = contentView.findViewById(R.id.idormname);
        dormtype = contentView.findViewById(R.id.idormtype);*/
        /*msdormname = contentView.findViewById(R.id.isdormname);*/
        msdormtype = contentView.findViewById(R.id.isdormtype);

        /*Adapter1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,dormitoriesName);
        Adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msdormname.setAdapter(Adapter1);*/


        AutoCompleteTextView msdormitoryname = contentView.findViewById(R.id.isdormname);




          FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //String uid, name, email;
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                //String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();

                // Name, email address, and profile photo Url
                String namee = profile.getDisplayName();
                String email = profile.getEmail();
                //Uri photoUrl = profile.getPhotoUrl();

                if (namee != null)
                    mwelcom.setText("Hi " + namee);
                else
                    mwelcom.setText("Hi "+ email);
            }
        }



          /*  if (DormitoryType == "0") {
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dormitoriesName);
                msdormitoryname.setAdapter(adapter);
            }

        if (DormitoryType == "1") {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, EMUdormitoriesName);
            msdormitoryname.setAdapter(adapter);
        }

        if (DormitoryType == "2") {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, privatedormitoriesName);
            msdormitoryname.setAdapter(adapter);
        }*/

        /*switch (DormitoryType){
            case "0":
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dormitoriesName);
                break;
            case "1":
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, EMUdormitoriesName);
                break;
            case "2":
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, privatedormitoriesName);
                break;
        }*/


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dormitoriesName);
        msdormitoryname.setAdapter(adapter);

        msdormitoryname.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                String selection = (String) parent.getItemAtPosition(position);
                int pos = -1;

                for (int i = 0; i < dormitoriesName.length; i++) {
                    if (dormitoriesName[i].equals(selection)) {
                        pos = i;
                        break;
                    }
                }
                switch (pos){
                    case 0:
                        dormid = null;
                        break;
                    case 1:
                        dormid ="5";
                        break;
                    case 2:
                        dormid = "5";
                        break;
                        default:
                            dormid = null;


                }
            }
        });



        /*msdormname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        dormid = null;
                        break;
                    case 1:
                        dormid ="5";
                        break;
                        default:
                            dormid ="35";


                }

                Toast.makeText(HomeActivity.this,"Hi "+dormitoriesName[position],Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/



        Adapter2=new ArrayAdapter(this,android.R.layout.simple_spinner_item,dormitorytype);
        Adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msdormtype.setAdapter(Adapter2);

        msdormtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        DormitoryType = "0";
                        break;
                    case 1:
                        DormitoryType = "1";
                        break;
                    case 2:
                        DormitoryType = "2";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        msearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: entered on click button");

                    if (dormid == null) {
                        Intent i = new Intent(HomeActivity.this, search_result_activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("alldorms", SearchAllDorms);
                        i.putExtras(bundle);
                        startActivity(i);
                    }
                    else {
                        Intent intent = new Intent(HomeActivity.this, Dormitory_detail.class);
                        intent.putExtra("DormId", dormid);
                        startActivity(intent);
                    }
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


                        try {
                            Log.d(TAG, "onResponse: Entered try");
                            JSONObject JO = response.getJSONObject("body");

                            JSONArray JA = JO.getJSONArray("dormitories");


                            for (int i=0; i<JA.length(); i++){

                                JSONObject dormitories = JA.getJSONObject(i);
                                String picture = dormitories.getString("pictureUrl");
                                String DormitoryName = dormitories.getString("dormitoryName");
                                String dormdescription = dormitories.getString("dormitoryDescription");
                                String ratingnumber = dormitories.getString("ratingNumber");
                                String ratingtext = dormitories.getString("ratingText");
                                String DormitoryId = dormitories.getString("dormitoryId");

                                SearchAllDorms.add(new SearchResultsListDataModel(DormitoryName, dormdescription, ratingnumber, ratingtext, picture,DormitoryId));
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
                            JSONObject JO = response.getJSONObject("body");

                            JSONArray JA = JO.getJSONArray("dormitories");

                            for (int i=0; i<JA.length(); i++){
                                JSONObject booking = JA.getJSONObject(i);
                                String picture = booking.getString("pictureUrl");
                                String DormitoryName = booking.getString("dormitoryName");
                                String Deals = booking.getString("dealsText");
                                String DormitoriTd = booking.getString("dormitoryId");

                                mHomeActivityDataModelsHighestRatedDorms.add(new HomeActivityDataModel(DormitoryName, Deals, 3, "$", true, picture, DormitoriTd));
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
                            JSONObject JO = response.getJSONObject("body");

                            JSONArray JA = JO.getJSONArray("dormitories");

                            for (int i=0; i<JA.length(); i++){
                                JSONObject booking = JA.getJSONObject(i);
                                String picture = booking.getString("pictureUrl");
                                String DormitoryName = booking.getString("dormitoryName");
                                String Deals = booking.getString("dealsText");
                                String DormitoriTd = booking.getString("dormitoryId");

                                mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(DormitoryName, Deals, 3, "$", true, picture, DormitoriTd));

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
