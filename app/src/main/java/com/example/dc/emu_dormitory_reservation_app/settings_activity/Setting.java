package com.example.dc.emu_dormitory_reservation_app.settings_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.About_us_activity.MainActivity;
import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Give_app_feedback_activity.Main2Activity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Sign_in_activity.Sign_in;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.google.firebase.auth.FirebaseAuth;

public class Setting extends AppCompatActivity implements View.OnClickListener {
    String[] language ={"English","Turkish"};
    Spinner lspinner;
    ArrayAdapter gspinnerAdapter;
    String[] currency ={"Dollas","TRY","Naira"};
    Spinner cspinner;
    String[] Informations = {"Terms and conditions","Send us your feedback","Rate us in the App store","About us"};
    ListView Linformation;
    ArrayAdapter spinnerAdapter,listadapter;
    private TextView msign_out;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        msign_out = (TextView)findViewById(R.id.isign_out);

        firebaseAuth = FirebaseAuth.getInstance();

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
                       // startActivity(new Intent(Setting.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );
        Myfun();

        msign_out.setOnClickListener(this);

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
        Linformation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        //terms and conditions
                        startActivity(new Intent(Setting.this, Terms_and_conditions.class));
                        break;
                    case 1:
                        //send us your feedback
                        startActivity(new Intent(Setting.this, Main2Activity.class));
                        break;
                    case 2:
                        // rate us in the app store
                        Toast.makeText(Setting.this, "up comming feature", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        // about us
                        startActivity(new Intent(Setting.this, MainActivity.class));
                        break;
                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v == msign_out){
            // log out the user
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, Sign_in.class));

        }
    }
}
