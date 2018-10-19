package com.example.dc.emu_dormitory_reservation_app.Create_account_activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.rate_your_stay_activity.Rate_your_stay;
import com.example.dc.emu_dormitory_reservation_app.sign_in_with_email_activity.Sign_in_with_Email;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.dc.emu_dormitory_reservation_app.R.id.create_account;

public class Create_Account extends AppCompatActivity implements View.OnClickListener {
    private EditText memail, mpassword;
    private TextView mcreate_acount;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__account);

        firebaseAuth = FirebaseAuth.getInstance();

        memail = (EditText)findViewById(R.id.iemail);
        mpassword = (EditText)findViewById(R.id.ipassword);
        mcreate_acount = (TextView)findViewById(R.id.icreate_account) ;

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
                       // startActivity(new Intent(Create_Account.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );


        mcreate_acount.setOnClickListener(this);

    }

    private void RegisterUser(){
        String email = memail.getText().toString().trim();
        String password = mpassword.getText().toString().trim();

        // validation check
        if (TextUtils.isEmpty(email)){
            // give a toes message that user must enter mail
            Toast.makeText(Create_Account.this, "please Enter  email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)){
            // give a toes message that user must enter password
            Toast.makeText(Create_Account.this, "please Enter  email", Toast.LENGTH_SHORT).show();
        }

        // if validated

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            // on successful registration
                            Toast.makeText(Create_Account.this, " Registration successful", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(Create_Account.this, HomeActivity.class));
                        }else {
                            // when registration fails
                            Toast.makeText(Create_Account.this, "Registration fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if (v == mcreate_acount){
            // Register the User
            RegisterUser();
        }
    }
}
