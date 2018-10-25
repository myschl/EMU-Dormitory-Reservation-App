package com.example.dc.emu_dormitory_reservation_app.manage_booking_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.R;

public class Manage_booking extends AppCompatActivity implements View.OnClickListener {
    Button Save,EditBooking,CancelBooking;

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
    }

    private void MyFun() {
        Save=(Button)findViewById(R.id.isave);
        EditBooking=(Button)findViewById(R.id.ieditbooking);
        CancelBooking=(Button)findViewById(R.id.icancelbooking);
    }

    @Override
    public void onClick(View v) {
        if (v == Save){
            //save operation
            SaveBooking();
        }
        if (v == EditBooking){
            // edit booking operations
            Editbooking();
        }
        if (v == CancelBooking){
            // cancel booking operations
            Cancelbooking();
        }
    }

    private void Cancelbooking() {
        // cancel booking here
        startActivity(new Intent(this, HomeActivity.class));
    }

    private void Editbooking() {
        // Edit booking here
        startActivity(new Intent(this, HomeActivity.class));
    }

    private void SaveBooking() {
        // save booking here
        startActivity(new Intent(this, HomeActivity.class));
    }
}
