package com.example.dc.emu_dormitory_reservation_app;

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

import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class Get_help extends AppCompatActivity {
    private Button mviewallquestion, mhaveaquestion;
    private TextView mcancel, mpayment, mpaymentt, mcancell;
    private ExpandableLayout paymentt, cancell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_help);
        Toolbar toolbar = (Toolbar)findViewById(R.id.get_help);
        toolbar.setTitle("Get Help");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Get_help.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        mviewallquestion = findViewById(R.id.iviewallquestions);
        mhaveaquestion = findViewById(R.id.ihavequestion);
        mcancel = findViewById(R.id.icanceltext);
        mpayment = findViewById(R.id.ipaymenttext);
/*
        mpayment.setText("payment answers");
        mcancel.setText("cancellation answers");*/


        mhaveaquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Get_help.this);
                builder.setMessage("by clicking on contnue you will be redirected to our Email page")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Get_help.this, "Your successfully redirected to our page", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(Room_detail.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


        mviewallquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Get_help.this);
                builder.setMessage("by clicking on contnue you will be redirected to our view all question page")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Get_help.this, "Your successfully redirected to our page", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(Room_detail.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

    public void payment(View view) {

        mpaymentt = findViewById(R.id.ipaymenttext);
        paymentt = findViewById(R.id.expandableLayout1);
        paymentt.toggle();
    }

    public void cancelation(View view) {
        mcancell = findViewById(R.id.icanceltext);
        cancell = findViewById(R.id.expandableLayout2);
        cancell.toggle();
    }



   /* @Override
    public void onClick(View v) {
        if (v == mviewallquestion){
            // view all suggested questions
            viewallquestion();
        }
        if (v == mhaveaquestion){
            // send us and email by clicking this button
        }

    }

    private void viewallquestion() {
        mviewallquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Get_help.this);
                builder.setMessage("by clicking on contnue you will be redirected to our view all question page")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Get_help.this, "Your successfully redirected to our page", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(Room_detail.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }*/
}
