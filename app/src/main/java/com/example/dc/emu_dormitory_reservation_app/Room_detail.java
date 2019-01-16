package com.example.dc.emu_dormitory_reservation_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
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
import android.widget.LinearLayout;
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
import com.example.dc.emu_dormitory_reservation_app.Navigational_drawer.navigational_drawer;
import com.example.dc.emu_dormitory_reservation_app.Sign_in_activity.Sign_in;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;
import com.example.dc.emu_dormitory_reservation_app.manage_booking_activity.Manage_booking;
import com.example.dc.emu_dormitory_reservation_app.rate_your_stay_activity.Rate_your_stay;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    //private ArrayList<RoomDetailImageModel> images = new ArrayList<>();
    private Button mbookroom, mrateyourstay, mmanagebooking, mbookroom2;
    ImageView viewPager;
    String name;
    private TextView mqota, mprice, mdormname, mroomname;
    // int images[] = {R.drawable.akdeniz_1, R.drawable.akdeniz_2, R.drawable.akdeniz_3, R.drawable.akdeniz_2};
    private ArrayList<RoomDetailImageModel> images = new ArrayList<>();

    private FirebaseAuth firebaseAuth;
    private DatabaseReference DR;
    private FirebaseUser user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    String userid, ExternalUserId;

    public static ArrayList<RoomQandPModel> roomQandP = new ArrayList<>();
    public static ArrayList<RoomDetailImageModel> imagess = new ArrayList<>();
    public static ArrayList<RoomDetailModel1> facilitiess = new ArrayList<>();

    private String bookingId, currentDate, currentTime, UserName, UserId, dormitoryId, RoomId, userstatus, bookingst;

    MyCustomPagerAdapter myCustomPagerAdapter;
    public String roomId, dormId, Rid, bookingNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);


        // from Domitory_detail Activity
        Bundle bundle1 = getIntent().getExtras();
        roomId = bundle1.getString("Roomid");
        dormId = bundle1.getString("DormId");


        // from booking Activity
        Bundle bundle = getIntent().getExtras();
        bookingNo = bundle.getString("bookingNo");
        dormId = bundle1.getString("DormId");
        roomId = bundle1.getString("Roomid");
        bookingst = bundle.getString("bookingst");


        SharedPreferences sharedPref = getSharedPreferences("userid", Context.MODE_PRIVATE);
        ExternalUserId = sharedPref.getString("ExternalUserId", "");


        Toolbar toolbar = (Toolbar) findViewById(R.id.room_detail);
        toolbar.setTitle("Room");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(Room_detail.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );


        mqota = findViewById(R.id.iqota);
        mprice = findViewById(R.id.iprice);
        mdormname = findViewById(R.id.idormname);
        mroomname = findViewById(R.id.iroomname);
        mbookroom = findViewById(R.id.ibookroom);
        mbookroom2 = findViewById(R.id.ibookroom2);
        mrateyourstay = findViewById(R.id.irateyourstay);
        mmanagebooking = findViewById(R.id.imanagebooking);


        mbookroom2.setVisibility(View.GONE);


        /*firebaseAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public  void  onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){

                    mbookroom2.setVisibility(View.GONE);
                    mbookroom.setVisibility(View.VISIBLE);

                }
            }

        };*/

        /*mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            if(firebaseAuth.getCurrentUser()!= null) {
                mbookroom2.setVisibility(View.GONE);
                mbookroom.setVisibility(View.VISIBLE);
            }
            }
        };*/


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        currentTime = format.format(calendar.getTime());
        currentDate = DateFormat.getInstance().format(calendar.getTime());

        /*FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        String userid = "" + currentFirebaseUser.getUid();*/


        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //String uid, name, email;
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                //String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();

                // Name, email address, and profile photo Url
                String namee = profile.getDisplayName();
                //String email = profile.getEmail();
                //Uri photoUrl = profile.getPhotoUrl();

                UserId = uid /*"11"*/;
                UserName = namee /*"abdul"*/;
            }
        }


        /*FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            userid = user.getUid();

            DR = FirebaseDatabase.getInstance().getReference().child("Users");
            DR.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    name = dataSnapshot.child(userid).child("name").getValue(String.class);

                    mbookroom2.setVisibility(View.GONE);
                    mbookroom.setVisibility(View.VISIBLE);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Room_detail.this, "Network Error", Toast.LENGTH_SHORT).show();

                }
            });
        }*/


        bookingId = bookingNo;
        dormitoryId = dormId;
        RoomId = roomId;


        if (bookingst == null) {
            mrateyourstay.setVisibility(View.GONE);
            mmanagebooking.setVisibility(View.GONE);
        }

        if (bookingst != null) {
            mbookroom.setVisibility(View.GONE);
            mbookroom2.setVisibility(View.GONE);
        }

        mrateyourstay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Room_detail.this, Rate_your_stay.class);
                intent.putExtra("Rid", Rid);
                intent.putExtra("bookingNo", bookingNo);
                intent.putExtra("DormId", dormId);
                startActivity(intent);


            }
        });

        mmanagebooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Room_detail.this, Manage_booking.class);
                intent.putExtra("Rid", Rid);
                intent.putExtra("bookingNo", bookingNo);
                intent.putExtra("DormId", dormId);
                startActivity(intent);

            }
        });

        mbookroom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Room_detail.this, "Sign in to book", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Room_detail.this, Sign_in.class));
            }
        });

        // booking dialog
        mbookroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user != null) {
                    BookRoom();
                } else {
                    startActivity(new Intent(Room_detail.this, Sign_in.class));
                    Toast.makeText(Room_detail.this, "Sign in to book", Toast.LENGTH_SHORT).show();
                }




                /*AlertDialog.Builder builder = new AlertDialog.Builder(Room_detail.this);
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
                alertDialog.show();*/

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
        /*Myfun();
        fRecycler();*/


    }

    private void BookRoom() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Room_detail.this);
        builder.setMessage("Are you sure you want to book this room");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // handle the user after clicking on yes button


                postNewBooking();


                Toast.makeText(Room_detail.this, "Your booking is successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Room_detail.this, Sbooking.class);
                intent.putExtra("userid", UserId);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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


    public void postNewBooking() {

        // mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(Room_detail.this);
        StringRequest sr = new StringRequest(Request.Method.POST, "http://35.204.232.129/api/CreateBooking", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //mPostCommentResponse.requestCompleted();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mPostCommentResponse.requestEndedWithError(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();

                params.put("bookingId", /*bookingNo*/ "0");
                params.put("currentDate", currentDate);
                params.put("currentTime", currentTime);
                params.put("userName", UserName);
                params.put("userId", /*ExternalUserId*/ UserId);
                params.put("dormitoryId", dormId /*"jsnxnc"*/);
                params.put("roomId", roomId /*"jdmnczm"*/);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }


    private void RoomDetailsAPI() {

        //String url = "https://api.myjson.com/bins/19pu48";
        String url = "http://35.204.232.129/api/GetRoomById/" + roomId;
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

                            String DormName = JO.getString("dormitoryName");
                            String RoomName = JO.getString("roomName");

                            mdormname.setText(DormName);
                            mroomname.setText(RoomName);

                            mqota.setText(RoomQota);
                            mprice.setText(RoomPrice);
                            Rid = RoomId;


                            /*//for facilities images and names
                            JSONArray JA = JO.getJSONArray("facilitiesList");

                            for (int i = 0; i < JA.length(); i++) {
                                JSONObject room = JA.getJSONObject(i);
                                String picture = room.getString("pictureUrl");
                                String name = room.getString("facilityname");
                                String facilityId = room.getString("facilityId");

                                facilities.add(new RoomDetailModel1(picture, name, facilityId));

                            }*/


                            // for facilities
                            JSONArray JAI = JO.getJSONArray("facilitiesList");

                            for (int i=0; i<JAI.length(); i++) {
                                JSONObject facility = JAI.getJSONObject(i);
                                String image = facility.getString("pictureUrl");
                                String name = facility.getString("facilityname");
                                String facilityId = facility.getString("facilityId");
                                facilities.add(new RoomDetailModel1(image, name, facilityId));
                                fRecycler();
                            }


                            // for images
                            /*JSONArray JAI = JO.getJSONArray("pictureUrl");

                            for (int i = 0; i < JAI.length(); i++) {
                                String image = JAI.getString(i);
                                images.add(new RoomDetailImageModel(image));

                            }*/

                            // for images
                            JSONArray JA = JO.getJSONArray("pictureUrl");
                            for (int i=0; i<JA.length(); i++){
                                String picture = JA.getString(i);
                                images.add(new RoomDetailImageModel(picture));
                                Myfun();
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


        /*facilities.add(new RoomDetailModel1("ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg", "wif" , "1"));
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

        RecyclerView recyclerView = findViewById(R.id.iroom_detail_recycleview);
        Room_detail_facilities_Adapter adapter = new Room_detail_facilities_Adapter(Room_detail.this, facilities);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Room_detail.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);


    }

    private void Myfun() {

        RecyclerView recyclerView = findViewById(R.id.iroomdetailimagerecycler);
        RoomDetailImagesAdapter adapter = new RoomDetailImagesAdapter(Room_detail.this, images);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Room_detail.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
    }
}
