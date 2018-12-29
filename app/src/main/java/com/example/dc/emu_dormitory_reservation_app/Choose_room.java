package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Choose_room extends AppCompatActivity {
    private RequestQueue mQueue;
    RecyclerView recyclerView;
    Choose_room_Adapter choose_room_adapter;
    ArrayList<Choose_room_class> recycle_items = new ArrayList<>();
    ArrayList<Choose_room_class> RoomDetailList = new ArrayList<>();


    public static ArrayList<RoomQandPModel> roomQandP = new ArrayList<>();
    public static ArrayList<RoomDetailImageModel> images = new ArrayList<>();
    public static ArrayList<RoomDetailModel1> facilities = new ArrayList<>();
    public static String roomqota, roomprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_room);
        Toolbar toolbar = (Toolbar)findViewById(R.id.choose_room);
        toolbar.setTitle("Choose Room");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Choose_room.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

     /*   mselectRoom = findViewById(R.id.choose_room_select);
        mselectRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Choose_room.this,Room_detail.class);
             *//*   Bundle bundle=new Bundle();
                bundle.putSerializable("allrooms",RoomDetailList);
                i.putExtras(bundle);*//*
                startActivity(i);
            }
        });*/


        /*Bundle bundle = getIntent().getExtras();
        DormId = bundle .getString("DormId");

        finalDormId = DormId;*/

        Bundle bundleobje=getIntent().getExtras();
        recycle_items=(ArrayList<Choose_room_class>) bundleobje.getSerializable("DormId");



       /* Choose_room_class croom = new Choose_room_class();
        String RoomId = croom.getRoomid();*/


        //DormitoryRoomss();
        MyFun();
        //RoomDetailAPI();

    }


    /*private void DormitoryRoomss() {
        String url = "http://35.204.232.129/api/GetRoomByDormitoryId/"+finalDormId;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("Body");


                            // for Rooms
                            JSONArray JAI = JO.getJSONArray("Rooms");

                            for (int i=0; i<JAI.length(); i++) {
                                JSONObject rooms = JAI.getJSONObject(i);
                                String image = rooms.getString("pictureUrl");
                                String name = rooms.getString("dormitoryName");
                                String bedtype = rooms.getString("bedType");
                                String roomsize = rooms.getString("roomSize");
                                String roomqota = rooms.getString("roomQuotaRemaining");
                                String roomPrice = rooms.getString("RoomPrice");
                                String roomid = rooms.getString("RoomId");
                                String dormid = rooms.getString("DormitoryId");

                                recycle_items.add(new Choose_room_class(image, name, bedtype, roomsize, roomqota, roomPrice));

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
        mQueue = Volley.newRequestQueue(Choose_room.this);
        mQueue.add(request);
    }*/

    /*private void RoomDetailAPI() {

        String url = "https://api.myjson.com/bins/19pu48";
        //String url = "http://35.204.232.129/api/GetRoomById/"+roomId;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        //Room id, qota and price
                        try {
                            JSONObject JO = response.getJSONObject("body");


                            String RoomId = JO.getString("roomId");
                            String RoomQota = JO.getString("roomQuota");
                            String RoomPrice = JO.getString("roomPrice");

                            roomqota = RoomQota;
                            roomprice = RoomPrice;
                            roomQandP.add(new RoomQandPModel(RoomQota, RoomPrice));


                            // for images
                            JSONArray JAI = JO.getJSONArray("pictureUrl");

                            for (int i=0; i<JAI.length(); i++){
                                String image = JAI.getString(i);
                                images.add(new RoomDetailImageModel(image));

                                //mHomeActivityDataModelsPopularDorms.add(new HomeActivityDataModel(DormitoryName, Deals, picture));

                            }


                            //for facilities images and names
                            JSONArray JA = JO.getJSONArray("facilitiesList");

                            for (int i=0; i<JA.length(); i++){
                                JSONObject room = JA.getJSONObject(i);
                                String picture = room.getString("pictureUrl");
                                String name = room.getString("facilityname");
                                String facilityId = room.getString("facilityId");


                                facilities.add(new RoomDetailModel1(picture, name, facilityId));

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
        mQueue = Volley.newRequestQueue(Choose_room.this);
        mQueue.add(request);

    }*/

    private void MyFun() {
        recyclerView = (RecyclerView)findViewById(R.id.choose_room_recycleview);
        //recyclerView.setHasFixedSize(true);


      /*  recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1277.jpg?RenditionID=7", "Akdeniz Single Room","1 single bed", "55m", "100 rooms left","$4500"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1268.jpg?RenditionID=7", "Akdeniz Double Room","2 single bed", "35m", "200 rooms left","$4000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1281.jpg?RenditionID=7", "Akdeniz Room","2 single bed", "25m", "0 rooms left","$6000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1250.jpg?RenditionID=7", "Akdeniz Single Room","2 single bed", "45m", "300 rooms left","$5000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1277.jpg?RenditionID=7", "Akdeniz Single Room","1 single bed", "55m", "100 rooms left","$4500"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1268.jpg?RenditionID=7", "Akdeniz Double Room","2 single bed", "35m", "200 rooms left","$4000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1281.jpg?RenditionID=7", "Akdeniz Room","2 single bed", "25m", "0 rooms left","$6000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1277.jpg?RenditionID=7", "Akdeniz Single Room","1 single bed", "55m", "100 rooms left","$4500"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1268.jpg?RenditionID=7", "Akdeniz Double Room","2 single bed", "35m", "200 rooms left","$4000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1281.jpg?RenditionID=7", "Akdeniz Room","2 single bed", "25m", "0 rooms left","$6000"));
*/

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        choose_room_adapter=new Choose_room_Adapter(Choose_room.this,recycle_items);
        recyclerView.setAdapter(choose_room_adapter);


    }
}
