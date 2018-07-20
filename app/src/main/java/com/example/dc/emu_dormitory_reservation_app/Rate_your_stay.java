package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Rate_your_stay extends AppCompatActivity {
    String[] feedback ={"Comment","Sugestion"};
    Spinner spinner;
    ArrayAdapter spinnerAdapter;

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
                        startActivity(new Intent(Rate_your_stay.this,DebugActivity.class));
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
    }
}
