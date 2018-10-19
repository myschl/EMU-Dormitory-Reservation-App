package com.example.dc.emu_dormitory_reservation_app.Sign_in_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.Create_account_activity.Create_Account;
import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.sign_in_with_email_activity.Sign_in_with_Email;

public class Sign_in extends AppCompatActivity implements View.OnClickListener {
    private Button memail, mfacebook, mstudent_no, mnew_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        memail = (Button)findViewById(R.id.iemail);
        mfacebook = (Button)findViewById(R.id.ifacebook);
        mstudent_no = (Button)findViewById(R.id.istudrnt_no);
        mnew_account = (Button)findViewById(R.id.icreate_new_account);

        Toolbar toolbar = (Toolbar)findViewById(R.id.sign_in);
        toolbar.setTitle("");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Sign_in.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                      //  startActivity(new Intent(Sign_in.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        memail.setOnClickListener(this);
        mfacebook.setOnClickListener(this);
        mstudent_no.setOnClickListener(this);
        mnew_account.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == memail){
            // goto email sign in activity
            finish();
            startActivity(new Intent(this, Sign_in_with_Email.class));
        }
        if (v == mfacebook){
            // facebook sign in
        }
        if (v == mstudent_no){
            // studentno sign in
        }
        if (v == mnew_account){
            // goto create new account activity
            finish();
            startActivity(new Intent(this, Create_Account.class));
        }
    }
}
