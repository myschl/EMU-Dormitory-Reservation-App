package com.example.dc.emu_dormitory_reservation_app.Give_app_feedback_activity;

import android.content.Intent;
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

public class Main2Activity extends AppCompatActivity {
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

        rate=(TextView)findViewById(R.id.rating_result);
        Awful=(ImageView)findViewById(R.id.awful);
        Poor=(ImageView)findViewById(R.id.poor);
        Average=(ImageView)findViewById(R.id.average);
        Good=(ImageView)findViewById(R.id.gone);
        Great=(ImageView)findViewById(R.id.great);
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

        SendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        //startActivity(new Intent(Main2Activity.this,.class));
            }
        });
    }

}
