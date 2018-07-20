package com.example.dc.emu_dormitory_reservation_app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Sign_in_with_student_No extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_with_student__no);

        Toolbar toolbar = (Toolbar)findViewById(R.id.sign_in_with_student_no);
        // toolbar.setTitle("Give app feedback");
        //toolbar.setSubtitle("welcome");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
    }
}
