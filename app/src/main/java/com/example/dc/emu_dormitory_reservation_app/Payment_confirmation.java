package com.example.dc.emu_dormitory_reservation_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
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
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivityDataModel;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Payment_confirmation extends AppCompatActivity {

    private RequestQueue mQueue;
    private TextView mbookingNo, mroombook, mdormitoryname, mconfexpdate, mbookingDate, mbookingStatus;
    private Button muploadpayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirmation);
        Toolbar toolbar = (Toolbar)findViewById(R.id.payment_confirmation);
        toolbar.setTitle("Payment Confirmation");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Payment_confirmation.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        mbookingDate = findViewById(R.id.ibookingdate);
        mbookingNo = findViewById(R.id.ibookingnumber);
        mconfexpdate = findViewById(R.id.icomfirmationexperydate);
        mdormitoryname = findViewById(R.id.idormitoryname);
        mroombook = findViewById(R.id.iroombooked);
        mbookingStatus = findViewById(R.id.ibookingstatus);
        muploadpayment = findViewById(R.id.iuploadpayment);

        muploadpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Payment_confirmation.this);
                builder.setMessage("by clicking on continue your booking payment receipt will be process")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Payment_confirmation.this, "Your booking receipt is successful send", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Payment_confirmation.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        //API call function
        MyBooking();


    }

    private void MyBooking() {
        String url = "http://35.204.232.129/api/BookingByBookingId/5";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject booking = response.getJSONObject("Body");

                                String PaymentComfirmationExpDate = booking.getString("paymentConfirmationExpiryDate");
                                String BookingStatus = booking.getString("BookingStatus");
                                String BookingDate = booking.getString("BookingDate");
                                String DormitoryId = booking.getString("DormitoryId");
                                String RomBooked = booking.getString("RoomBooked");
                                String DormitoryName = booking.getString("DormitoryName");
                                String BookingNumber = booking.getString("BookingNo");

                                mbookingDate.setText(BookingDate);
                                mconfexpdate.setText(PaymentComfirmationExpDate);
                                mbookingNo.setText(BookingNumber);
                                mroombook.setText(RomBooked);
                                mdormitoryname.setText(DormitoryName);
                                mbookingStatus.setText(BookingStatus);


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
        mQueue = Volley.newRequestQueue(Payment_confirmation.this);
        mQueue.add(request);
    }


}
