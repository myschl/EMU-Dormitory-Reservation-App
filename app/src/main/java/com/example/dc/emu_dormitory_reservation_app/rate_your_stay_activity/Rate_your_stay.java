package com.example.dc.emu_dormitory_reservation_app.rate_your_stay_activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Room_detail;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rate_your_stay extends AppCompatActivity {
    String[] feedback ={"Comment","Sugestion"};
    Spinner spinner;
    ArrayAdapter spinnerAdapter;
    Button mfeedback;
    EditText mcommentt;
    RatingBar mrfacility, mrservice, mrcompound;

    private ArrayList<String> FeedbackType = new ArrayList<>();
    private ArrayList<String> Addcomment = new ArrayList<>();
    private ArrayList<String> Facilities = new ArrayList<>();
    private ArrayList<String> Services = new ArrayList<>();
    private ArrayList<String> Compound = new ArrayList<>();

    private String mFeedbackType,mAddcomment, mFacilities, mServices, mCompound, roomid, bookingNo,dormitoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_your_stay);


        Intent intent = getIntent();
        roomid = intent.getStringExtra("Rid");
        bookingNo = intent.getStringExtra("bookingNo");
        dormitoryId = intent.getStringExtra("DormId");

        mcommentt = findViewById(R.id.iaddcomment);
        mrfacility = findViewById(R.id.ifacility);
        mrservice = findViewById(R.id.iservice);
        mrcompound = findViewById(R.id.icompound);


        mFeedbackType = "comment";
        mAddcomment = mcommentt.getText()+"";
        /*mFacilities = "4";
        mServices = "5";
        mCompound = "3";*/

      /*  mrfacility.setNumStars(5);
        mrservice.setNumStars(5);
        mrcompound.setNumStars(5);*/


        mrfacility.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mFacilities = (int)rating+"";
            }
        });

        mrservice.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mServices = (int)rating+"";
            }
        });

        mrcompound.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mCompound = (int)rating+"";
            }
        });



        MyFun();
    }

    private void MyFun() {
        spinner=(Spinner)findViewById(R.id.feedback_spinner);
        Toolbar toolbar = (Toolbar)findViewById(R.id.rate_your_stay);

        toolbar.setTitle("Rate your stay");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);

        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Rate_your_stay.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        //startActivity(new Intent(Rate_your_stay.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,feedback);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mFeedbackType = "Comment";
                        break;
                    case 1:
                        mFeedbackType = "Sugestion";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mfeedback = findViewById(R.id.isendfeedback);
        mfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Rate_your_stay.this);
                builder.setMessage("we will use your feedback to increase our dormitory services")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button

                                postRateBooking();

                                Toast.makeText(Rate_your_stay.this, "Your feedback is successful send", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(Rate_your_stay.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

   /* @Override
    public void onClick(View v) {
        if (v == mfeedback){
            // save the feedback
            Feedback();
        }
    }

    private void Feedback() {
        mfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Rate_your_stay.this);
                builder.setMessage("we will use your feedback to increase our dormitory services")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Rate_your_stay.this, "Your feedback is successful send", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(Rate_your_stay.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }*/


    public void postRateBooking( ){
        // mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(Rate_your_stay.this);
        StringRequest sr = new StringRequest(Request.Method.POST,"http://35.204.232.129/api/RateYourStay", new Response.Listener<String>() {
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
                params.put("feedbackType", mFeedbackType  );
                params.put("addcomment", mAddcomment);
                params.put("facilities", mFacilities);
                params.put("services", mServices);
                params.put("compound", mCompound);
                params.put("dormitoryId", dormitoryId);

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

    public interface PostCommentResponseListener {
        public void requestStarted();
        public void requestCompleted();
        public void requestEndedWithError(VolleyError error);
    }

}
