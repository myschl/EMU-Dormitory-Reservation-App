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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Room_detail;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;

public class Rate_your_stay extends AppCompatActivity {
    String[] feedback ={"Comment","Sugestion"};
    Spinner spinner;
    ArrayAdapter spinnerAdapter;
    Button mfeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_your_stay);

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
}
