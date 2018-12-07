package com.example.dc.emu_dormitory_reservation_app.manage_booking_activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import com.example.dc.emu_dormitory_reservation_app.Choose_room_class;
import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Dormitory_detail;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.ManageBookingModel;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Room_detail;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;
import com.example.dc.emu_dormitory_reservation_app.edit_booking_activity.Edit_booking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Manage_booking extends AppCompatActivity {
    private RequestQueue mQueue;
    Button Save,EditBooking,CancelBooking;
    private TextView mdateofbooking, mtimeofbooking, mcheckindate, mcheckinsemester;
    private ArrayList<ManageBookingModel> bookinginfor = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_booking);
        Toolbar toolbar = (Toolbar)findViewById(R.id.manage_booking);
         toolbar.setTitle("Manage Booking");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Manage_booking.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                       // startActivity(new Intent(Manage_booking.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        MyFun();
        BookingInformationAPI();
    }

    private void BookingInformationAPI() {
        String url = "http://35.204.232.129/api/GetBooking/34";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("Body");

                            // for Rooms

                                String Dateofbooking = JO.getString("DateOfBooking");
                                String Timeofbooking = JO.getString("TimeOfBooking");
                                String checkindate = JO.getString("CheckInDate");
                                String checkinsemester = JO.getString("CheckInSemester");

                                 mdateofbooking.setText(Dateofbooking);
                                 mtimeofbooking.setText(Timeofbooking);
                                 mcheckindate.setText(checkindate);
                                 mcheckinsemester.setText(checkinsemester);

                                bookinginfor.add(new ManageBookingModel(Dateofbooking, Timeofbooking, checkindate, checkinsemester));


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
        mQueue = Volley.newRequestQueue(Manage_booking.this);
        mQueue.add(request);
    }

    private void MyFun() {
        //Save=(Button)findViewById(R.id.isave);
        EditBooking=(Button)findViewById(R.id.ieditbooking);
        CancelBooking=(Button)findViewById(R.id.icancelbooking);
        mdateofbooking = findViewById(R.id.idateofbooking);
        mtimeofbooking = findViewById(R.id.itimeofbooking);
        mcheckindate = findViewById(R.id.icheckindate);
        mcheckinsemester = findViewById(R.id.icheckinsemester);

        EditBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Edit booking here
                Intent i=new Intent(Manage_booking.this,Edit_booking.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("bookinginfo", bookinginfor);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        // cancel booking here
        //Toast.makeText(this, "up comming feature", Toast.LENGTH_SHORT).show();
        CancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Manage_booking.this);
                builder.setMessage("Are you sure you want to cancel your booking ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Manage_booking.this, "Your booking is successful canceled", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Manage_booking.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("No", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

}
