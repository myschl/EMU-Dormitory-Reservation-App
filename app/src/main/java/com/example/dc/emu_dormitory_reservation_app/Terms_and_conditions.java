package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Terms_and_conditions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        Toolbar toolbar = (Toolbar)findViewById(R.id.term_and_condition);
        toolbar.setTitle("Terms and Conditions");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Terms_and_conditions.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                    }
                }

        );
    }
}
