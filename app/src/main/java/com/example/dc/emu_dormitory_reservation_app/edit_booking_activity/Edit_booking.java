package com.example.dc.emu_dormitory_reservation_app.edit_booking_activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.ManageBookingModel;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Room_detail;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsActivity2;

import java.util.ArrayList;
import java.util.Calendar;

public class Edit_booking extends AppCompatActivity {
    Button Save;
    private String[] semesterlist = {"Spring", "Fall", "Summer"};
    private Spinner msemesterlist;
    private TextView mcheckindate, mdateofbooking, mtimeofbooking;
    private ManageBookingModel bookinginfoo = new ManageBookingModel();

    private ArrayList<ManageBookingModel> bookingInfo = new ArrayList<>();
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_booking);
        Toolbar toolbar = (Toolbar)findViewById(R.id.edit_booking);
        toolbar.setTitle("Edit Booking");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Edit_booking.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                       // startActivity(new Intent(Edit_booking.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        // getting Arraylist of booking info
        Bundle bundleobje = getIntent().getExtras();
        bookingInfo=(ArrayList<ManageBookingModel>) bundleobje.getSerializable("bookinginfo");



        mdateofbooking = findViewById(R.id.idateofbooking);
        mtimeofbooking = findViewById(R.id.itimeofbooking);
        mcheckindate = findViewById(R.id.icheckindate);
        msemesterlist = findViewById(R.id.checkinsemesterspinner);


        // setting date and time of booking
        mdateofbooking.setText(bookingInfo.get(0).getCheckindate());
        mtimeofbooking.setText(bookingInfo.get(0).getTimeofbooking());


        Save = (Button)findViewById(R.id.isave);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Edit_booking.this);
                builder.setMessage("by clicking on continue yor booking will be edited ")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Edit_booking.this, "Your booking is successful edited", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Edit_booking.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, semesterlist);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msemesterlist.setAdapter(adapter);

        msemesterlist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mcheckindate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Edit_booking.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
               // Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mcheckindate.setText(date);
            }
        };

    }
}
