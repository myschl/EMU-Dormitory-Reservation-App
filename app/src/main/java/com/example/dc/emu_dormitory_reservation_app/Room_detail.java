package com.example.dc.emu_dormitory_reservation_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivityDataModel;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;
import com.example.dc.emu_dormitory_reservation_app.rate_your_stay_activity.Rate_your_stay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Room_detail extends AppCompatActivity {
    //private static Rate_your_stay.PostCommentResponseListener mPostCommentResponse;
    private RequestQueue mQueue;
    private ArrayList fimage = new ArrayList();
    private ArrayList fname = new ArrayList();
    private ArrayList<RoomDetailModel1> facilities = new ArrayList<>();
    //private ArrayList<String> images = new ArrayList<>();
    private Button mbookroom;
    ImageView viewPager;
    private TextView mqota, mprice;
   // int images[] = {R.drawable.akdeniz_1, R.drawable.akdeniz_2, R.drawable.akdeniz_3, R.drawable.akdeniz_2};
    private ArrayList<RoomDetailImageModel> images = new ArrayList<>();

    public static ArrayList<RoomQandPModel> roomQandP = new ArrayList<>();
    public static ArrayList<RoomDetailImageModel> imagess = new ArrayList<>();
    public static ArrayList<RoomDetailModel1> facilitiess = new ArrayList<>();

    private String bookingId, currentDate, currentTime, UserName, UserId, dormitoryId, RoomId;

    MyCustomPagerAdapter myCustomPagerAdapter;
    public String roomId, dormId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);




        Bundle bundle = getIntent().getExtras();
        roomId = bundle .getString("Roomid");
        dormId = bundle.getString("DormId");


        Toolbar toolbar = (Toolbar)findViewById(R.id.room_detail);
        toolbar.setTitle("Room");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Room_detail.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );


        mqota = findViewById(R.id.iqota);
        mprice = findViewById(R.id.iprice);
        mbookroom = findViewById(R.id.ibookroom);



        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        currentTime = format.format(calendar.getTime());
        currentDate = DateFormat.getInstance().format(calendar.getTime());

        bookingId ="1";
        UserId = "11";
        UserName = "Abdul";
        dormitoryId = dormId;
        RoomId = roomId;




        // booking dialog
        mbookroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Room_detail.this);
                builder.setMessage("Are you sure you want to book this room");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // handle the user after clicking on yes button


                        postNewBooking();


                        Toast.makeText(Room_detail.this, "Your booking is successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Room_detail.this, HomeActivity.class));
                    }
                });
                builder.setNegativeButton("No", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });





        // getting room detail from choose room activity Adapter
/*
        Bundle bundleobje=getIntent().getExtras();
        roomQandP=(ArrayList<RoomQandPModel>) bundleobje.getSerializable("roomQandP");
        imagess =(ArrayList<RoomDetailImageModel>) bundleobje.getSerializable("images");
        facilitiess =(ArrayList<RoomDetailModel1>) bundleobje.getSerializable("facilities");

        mqota.setText();
        mprice.setText(roomQandP.get(0).getRoomprice());
        String RoomId = roomQandP.get(0).getRoomId();*/




        RoomDetailsAPI();
        //Myfun();
        fRecycler();


    }



    /*public void postNewBooking( ){
       // mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(Room_detail.this);
        StringRequest sr = new StringRequest(Request.Method.POST,"http://35.204.232.129/api/CreateBooking", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //mPostCommentResponse.requestCompleted();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mPostCommentResponse.requestEndedWithError(error);
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("bookingId", *//*bookingId.toString()*//* "hehdh");
                params.put("currentDate", *//*currentDate.toString()*//* "hdcdan");
                params.put("currentTime", *//*CurrentTime.toString()*//* "jddncnc");
                params.put("userName", *//*UserName.toString()*//* "jdjdcnjcn");
                params.put("userId", *//*userId.toString()*//* "hjdajdn");
                params.put("dormitoryId", *//*dormitoryId.toString()*//* "jsnxnc");
                params.put("roomId", *//*roomId.toString()*//* "jdmnczm ");

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
    }*/

    public interface PostCommentResponseListener {
        public void requestStarted();
        public void requestCompleted();
        public void requestEndedWithError(VolleyError error);
    }




    public void postNewBooking( ){

        // mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(Room_detail.this);
        StringRequest sr = new StringRequest(Request.Method.POST,"http://35.204.232.129/api/CreateBooking", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //mPostCommentResponse.requestCompleted();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mPostCommentResponse.requestEndedWithError(error);
            }
        }){
            @Override
            protected Map<String,String> getParams(){

                Map<String,String> params = new HashMap<String, String>();

                params.put("bookingId", bookingId /*"hehdh"*/);
                params.put("currentDate", currentDate /*"hdcdan"*/);
                params.put("currentTime", currentTime /*"jddncnc"*/);
                params.put("userName", UserName /*"jdjdcnjcn"*/);
                params.put("userId", UserId /*"hjdajdn"*/);
                params.put("dormitoryId", dormId /*"jsnxnc"*/);
                params.put("roomId", RoomId /*"jdmnczm "*/);

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




    private void RoomDetailsAPI() {

        //String url = "https://api.myjson.com/bins/19pu48";
        String url = "http://35.204.232.129/api/GetRoomById/"+roomId;
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

                            mqota.setText(RoomQota);
                            mprice.setText(RoomPrice);


                            // for images
                            JSONArray JAI = JO.getJSONArray("pictureUrl");

                            for (int i=0; i<JAI.length(); i++){
                                String image = JAI.getString(i);
                                images.add(new RoomDetailImageModel(image));

                            }


                            //for facilities images and names
                            JSONArray JA = JO.getJSONArray("facilitiesList");

                            for (int i=0; i<JA.length(); i++){
                                JSONObject room = JA.getJSONObject(i);
                                String picture = room.getString("pictureUrl");
                                String name = room.getString("facilityname");
                                String facilityId = room.getString("facilityId");


                                facilities.add(new RoomDetailModel1(picture, name, facilityId));

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
        mQueue = Volley.newRequestQueue(Room_detail.this);
        mQueue.add(request);
    }


    private void fRecycler() {


        /*facilities.add(new RoomDetailModel1("ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg", "wif" ));
        fimage.add("http://ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg");
        fname.add("wif");
        fimage.add("http://en.alfamcyprus.com/thumbnail.php?file=images/2.jpg&pwidth=1903&pheight=850&pw=475.7500&ph=212.5000&px=0.0000&py=0.0000&pscale=0.2500&pangle=0.0000&force=y");
        fname.add("Telephone");
        fimage.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        fname.add("TV");
        fimage.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        fname.add("Fridge");
        fimage.add("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg");
        fname.add("");
        fimage.add("http://ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg");
        fname.add("wif");
        fimage.add("http://en.alfamcyprus.com/thumbnail.php?file=images/2.jpg&pwidth=1903&pheight=850&pw=475.7500&ph=212.5000&px=0.0000&py=0.0000&pscale=0.2500&pangle=0.0000&force=y");
        fname.add("Telephone");
        fimage.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        fname.add("TV");*/

        RecyclerView recyclerView = findViewById(R.id.room_detail_recycleview);
        Room_detail_facilities_Adapter adapter = new Room_detail_facilities_Adapter(this, facilitiess);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Room_detail.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);

        RecyclerView recyclerView1 = findViewById(R.id.iroomdetailimagerecycler);
        RoomDetailImagesAdapter adapter1 = new RoomDetailImagesAdapter(this, imagess );
        recyclerView1.setAdapter(adapter1);
        LinearLayoutManager horizontalLayoutManagaer1 = new LinearLayoutManager(Room_detail.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManagaer1);


    }

  /*  private void Myfun() {

        *//*viewPager = (ViewPager)findViewById(R.id.viewPager);

        //myCustomPagerAdapter = new MyCustomPagerAdapter(Room_detail.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);*//*
    }*/
}
