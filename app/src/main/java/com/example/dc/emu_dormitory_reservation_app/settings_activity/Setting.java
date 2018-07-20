package com.example.dc.emu_dormitory_reservation_app.settings_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.R;

public class Setting extends AppCompatActivity {
    String[] language ={"English","Turkish"};
    Spinner lspinner;
    ArrayAdapter gspinnerAdapter;
    String[] currency ={"Dollas","TRY","Naira"};
    Spinner cspinner;
    String[] Informations = {"Terms and conditions","Send us your feedback","Rate us in the App store","About us"};
    ListView Linformation;
    ArrayAdapter spinnerAdapter,listadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar)findViewById(R.id.setting);
        toolbar.setTitle("Setting");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Setting.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Setting.this,DebugActivity.class));
                    }
                }

        );
        Myfun();
    }

    private void Myfun() {
        lspinner=(Spinner)findViewById(R.id.language_spinner);
        cspinner=(Spinner)findViewById(R.id.currency_spinner);
        Linformation=(ListView)findViewById(R.id.information);

        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,language);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lspinner.setAdapter(spinnerAdapter);

        lspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,currency);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cspinner.setAdapter(spinnerAdapter);

        cspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listadapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,Informations);
        Linformation.setAdapter(listadapter);


    }
}
