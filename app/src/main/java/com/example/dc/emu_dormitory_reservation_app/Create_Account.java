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

public class Create_Account extends AppCompatActivity {
    String[] gender ={"Male","Female"};
    Spinner gspinner;
    ArrayAdapter gspinnerAdapter;
    String[] Dateofbirth ={"1993","1994","2000","2018"};
    Spinner dspinner;
    ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__account);
        Toolbar toolbar = (Toolbar)findViewById(R.id.create_account);
        toolbar.setTitle("");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Create_Account.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Create_Account.this,DebugActivity.class));
                    }
                }

        );

        MyFun();
    }

    private void MyFun() {
        gspinner=(Spinner)findViewById(R.id.gender_spinner);
        dspinner=(Spinner)findViewById(R.id.date_of_birth_spinner);

        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gspinner.setAdapter(spinnerAdapter);

        gspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,Dateofbirth);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dspinner.setAdapter(spinnerAdapter);

        dspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
