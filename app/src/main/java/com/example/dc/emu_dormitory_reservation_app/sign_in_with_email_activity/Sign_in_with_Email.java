package com.example.dc.emu_dormitory_reservation_app.sign_in_with_email_activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_in_with_Email extends AppCompatActivity implements View.OnClickListener {
    private EditText memail, mpassword;
    private TextView msign_in;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_with__email);

        firebaseAuth = FirebaseAuth.getInstance();

        memail = (EditText)findViewById(R.id.iemail);
        mpassword = (EditText)findViewById(R.id.ipassword);
        msign_in = (TextView)findViewById(R.id.isign_in);

        Toolbar toolbar = (Toolbar)findViewById(R.id.sign_in_with_email);
        toolbar.setTitle("");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Sign_in_with_Email.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                       // startActivity(new Intent(Sign_in_with_Email.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        msign_in.setOnClickListener(this);

    }

    private void SignUser(){
        String email = memail.getText().toString().trim();
        String password = mpassword.getText().toString().trim();

        // check for validation

        if (TextUtils.isEmpty(email)){
            // give a toes message that user must enter mail
            Toast.makeText(Sign_in_with_Email.this, "please Enter  email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)){
            // give a toes message that user must enter password
            Toast.makeText(Sign_in_with_Email.this, "Please Enter password", Toast.LENGTH_SHORT).show();
        }

        // validated

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            // log in the user
                            Toast.makeText(Sign_in_with_Email.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(Sign_in_with_Email.this, HomeActivity.class));
                        }else {
                            // display an error message
                            Toast.makeText(Sign_in_with_Email.this, "Sign in fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == msign_in){
            // log in the user
            SignUser();
        }
    }
}
