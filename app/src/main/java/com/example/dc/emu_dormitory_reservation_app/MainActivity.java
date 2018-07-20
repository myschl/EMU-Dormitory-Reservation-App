package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//comment
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.about_us);
        toolbar.setTitle("About us");
        //toolbar.setSubtitle("welcome");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this,DebugActivity.class));
                    }
                }

        );
       // MyFun();

    }

}
