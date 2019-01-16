package com.example.dc.emu_dormitory_reservation_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.Navigational_drawer.navigational_drawer;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Sbooking extends AppCompatActivity {
    private TextView mhome, mbooking;
    private String userid, ExternalUserId;
    private RequestQueue mQueue;

    private ArrayList<BookingbyCustomerId> Alldorms = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbooking);

        mhome = findViewById(R.id.ihome);
        mbooking = findViewById(R.id.ibooking);

        Bundle bundle = getIntent().getExtras();
        userid = bundle.getString("userid");

        SharedPreferences sharedPref = getSharedPreferences("userid", Context.MODE_PRIVATE);
        ExternalUserId = sharedPref.getString("ExternalUserId", "");

        mhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sbooking.this, HomeActivity.class));
            }
        });

        mbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sbooking.this,booking_tabbed_activity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("alldorms",Alldorms);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        DormitoriesAPI();

    }

    private void DormitoriesAPI() {
        String url = "http://35.204.232.129/api/GetBookingsByCustomerId/18e9df11-8b9a-4253-8f02-69387bb68422" /*+ ExternalUserId*/;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("body");

                            JSONArray JA = JO.getJSONArray("bookings");

                            for (int i=0; i<JA.length(); i++){

                                JSONObject booking = JA.getJSONObject(i);
                                String DormitoryDescription = booking.getString("dormitoryDescription");
                                String DormitoryId = booking.getString("dormitoryId");
                                String BookingNo = booking.getString("bookingNumber");
                                String Dormitoryname = booking.getString("dormitoryname");
                                String PictureUrl = booking.getString("pictureUrl");
                                String RatingNumber = booking.getString("ratingNumber");
                                String RatingText = booking.getString("ratingText");
                                String BookingDate = booking.getString("bookingDate");
                                String CheckInDate = booking.getString("checkInDate");
                                String BookingStatus = booking.getString("bookingStatus");
                                String RoomId = booking.getString("roomId");

                                Alldorms.add(new BookingbyCustomerId(Dormitoryname, DormitoryDescription, BookingDate, CheckInDate, BookingStatus,PictureUrl,RatingNumber,RatingText, DormitoryId, BookingNo, RoomId));
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
        mQueue = Volley.newRequestQueue(Sbooking.this);
        mQueue.add(request);
    }
}
