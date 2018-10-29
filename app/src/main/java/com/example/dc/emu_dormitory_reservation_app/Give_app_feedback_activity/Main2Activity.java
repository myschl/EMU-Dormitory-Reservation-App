package com.example.dc.emu_dormitory_reservation_app.Give_app_feedback_activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Facilities_filters;
import com.example.dc.emu_dormitory_reservation_app.Filter_by_activity.Filter_by;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Room_detail;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView rate;
    Button SendFeedback;
    ImageView Awful,Poor,Average,Good,Great;
    String[] information ={"comment","Suggestion"};
    Spinner spinner;
    ArrayAdapter spinnerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // activity2
        //another commit comment
        //features commit comment

        Toolbar toolbar = (Toolbar)findViewById(R.id.give_app_feedback);
        toolbar.setTitle("Give app feedback");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Main2Activity.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                       // startActivity(new Intent(Main2Activity.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );
        MyFun();
    }

    private void MyFun() {

        rate=(TextView)findViewById(R.id.irating_result);
        Awful=(ImageView)findViewById(R.id.iawful);
        Poor=(ImageView)findViewById(R.id.ipoor);
        Average=(ImageView)findViewById(R.id.iaverage);
        Good=(ImageView)findViewById(R.id.igood);
        Great=(ImageView)findViewById(R.id.igreat);
        spinner=(Spinner)findViewById(R.id.spinner);
        SendFeedback=(Button)findViewById(R.id.sendfeedback);

        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,information);
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


        Awful.setOnClickListener(this);
        Poor.setOnClickListener(this);
        Average.setOnClickListener(this);
        Good.setOnClickListener(this);
        Great.setOnClickListener(this);
        SendFeedback.setOnClickListener(this);

        /*Awful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate.setText("Awful");
            }
        });

        Poor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate.setText("Poor");
            }
        });

        Average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate.setText("Average");
            }
        });

        Good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate.setText("Good");
            }
        });

        Great.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate.setText("Great");
            }
        });*/

       /* SendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        //startActivity(new Intent(Main2Activity.this,.class));
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        if (v == Awful){
            rate.setText("Awful");
            rate.setTextColor(Color.RED);
            Awful.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAlert));
            //DrawableCompat.setTint(Awful.getDrawable(), ContextCompat.getColor(getApplicationContext(), R.color.blue));

        }
        if (v == Poor){
            rate.setText("Poor");
            rate.setTextColor(Color.YELLOW);
            Poor.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorYellowBackground));

        }
        if (v == Good){
            rate.setText("Good");
            rate.setTextColor(Color.CYAN);
            Good.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));

        }
        if (v == Average){
            rate.setText("Average");
            rate.setTextColor(Color.BLUE);
            Average.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.blue));

        }
        if (v == Great){
            rate.setText("Great");
            rate.setTextColor(Color.GREEN);
            Great.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.green));

        }
        if (v == SendFeedback){
            // send feedbact when click
            Sendfeedback();

        }
    }

    private void Sendfeedback() {
        SendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setMessage("Your feedback will be used to increase our services")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Main2Activity.this, "Your feedback is successful send", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(Main2Activity.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }
}
