package com.example.dc.emu_dormitory_reservation_app.Create_account_activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.UserDataModel;
import com.example.dc.emu_dormitory_reservation_app.rate_your_stay_activity.Rate_your_stay;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.SearchResultsListDataModel;
import com.example.dc.emu_dormitory_reservation_app.sign_in_with_email_activity.Sign_in_with_Email;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.dc.emu_dormitory_reservation_app.R.id.create_account;

public class Create_Account extends AppCompatActivity implements View.OnClickListener {
    private RequestQueue mQueue;
    private EditText memail, mpassword, musername;
    private TextView mcreate_acount;
    private String Email, Name;
    private String ExternalUserId;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference DR;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__account);


        firebaseAuth = FirebaseAuth.getInstance();
        DR = FirebaseDatabase.getInstance().getReference().child("Users");


        dialog = new ProgressDialog(Create_Account.this);

        memail = (EditText)findViewById(R.id.iemail);
        mpassword = (EditText)findViewById(R.id.ipassword);
        mcreate_acount = (TextView)findViewById(R.id.icreate_account);
        musername = findViewById(R.id.iusername);

        Email = memail.getText().toString();
        Name = musername.getText().toString();


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
        final String email = memail.getText().toString().trim();
        final String password = mpassword.getText().toString().trim();

        // validation check
        if (TextUtils.isEmpty(email)){
            // give a toes message that user must enter mail
            Toast.makeText(Create_Account.this, "please Enter  email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)){
            // give a toes message that user must enter password
            Toast.makeText(Create_Account.this, "please Enter  password", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
            // give a toes message that user must enter email and password
            Toast.makeText(Create_Account.this, "please Enter  email and password", Toast.LENGTH_SHORT).show();
        }

        // if validated

        Externaldatabase();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            // on successful registration


                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();



                           /* String uid, uname=null, uemail=null;
                            Uri photoUrl =null;
                            if (user != null) {
                                for (UserInfo profile : user.getProviderData()) {
                                    // Id of the provider (ex: google.com)
                                    //String providerId = profile.getProviderId();

                                    // UID specific to the provider
                                    //String uid = profile.getUid();

                                    // Name, email address, and profile photo Url
                                    uname = profile.getDisplayName();
                                    uemail = profile.getEmail();
                                    photoUrl = profile.getPhotoUrl();

                                    // create user in the database
                                    //postNewUser(uemail, password, uname, uname, String.valueOf(photoUrl), null );

                                }
                            }

                            // create user in the database
                            postNewUser(email, password, uname, uname, String.valueOf(photoUrl), null );*/


                            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){

                                        Toast.makeText(Create_Account.this, "Check your email for validation", Toast.LENGTH_LONG).show();
                                        //FirebaseAuth.getInstance().signOut();

                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(Create_Account.this, "Fail to send email for verification", Toast.LENGTH_LONG).show();

                                }
                            });


                           String UserId = firebaseAuth.getCurrentUser().getUid();
                           DatabaseReference currentuser = DR.child(UserId);

                           currentuser.child("name").setValue(musername.getText().toString());
                           currentuser.child("email").setValue(memail.getText().toString());
                           // external databse user id
                            //currentuser.child("userId").setValue("");

                            Toast.makeText(Create_Account.this, " Registration successful", Toast.LENGTH_SHORT).show();
                            finish();
                            String email = String.valueOf(memail.getText());
                            String password = String.valueOf(mpassword.getText());

                            String username = String.valueOf(musername.getText());


                            //final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();



                            Intent intent = new Intent(Create_Account.this, Sign_in_with_Email.class);
                            intent.putExtra("email", email);
                            intent.putExtra("password", password);
                            startActivity(intent);
                            dialog.dismiss();

                            //startActivity(new Intent(Create_Account.this, HomeActivity.class));
                        }else {
                            // when registration fails
                            Toast.makeText(Create_Account.this, "Registration fail check your connection", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });

    }


    // create user in the database function
    private void postNewUser(final String email, final String password, final String userfirstname, final String userlastname, final String userimage, final String gender) {

        // mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(Create_Account.this);
        StringRequest sr = new StringRequest(Request.Method.POST, "http://35.204.232.129/api/CreateUser", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //mPostCommentResponse.requestCompleted();

                try {

                    JSONObject responces = new JSONObject(response.toString());
                    JSONObject JO = responces.getJSONObject("body");


                        String userId = JO.getString("userId");

                        ExternalUserId = userId;

                        sherefref(ExternalUserId);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mPostCommentResponse.requestEndedWithError(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();

                params.put("email", email /*"hdbdh"*/);
                params.put("password", password /*"sjhjshx"*/);
                params.put("userFirstName", userfirstname /*"kjjhj"*/);
                params.put("userLastName", userlastname /*"sdsdj"*/);
                params.put("userImageString", userimage /*"sjsjhdjshn"*/);
                params.put("userGender", gender /*"dhdhh"*/);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }

    private void sherefref(String ExternalUserId) {
        SharedPreferences sharedPref = getSharedPreferences("userId", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("ExternalUserId", /*ExternalUserId*/ "18e9df11-8b9a-4253-8f02-69387bb68422");
        editor.apply();
    }


   /* private void sendEmailVerification() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Create_Account.this, "Check your email for validation", Toast.LENGTH_LONG).show();
                        FirebaseAuth.getInstance().signOut();
                    }
                }
            });
        }
    }*/



    @Override
    public void onClick(View v) {
        if (v == mcreate_acount){
            // Register the User
            dialog.setMessage("Registering...");
            dialog.setCancelable(false);
            dialog.show();

            /*Externaldatabase();*/

            RegisterUser();

        }
    }

    private void Externaldatabase() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        final String email = memail.getText().toString().trim();
        final String password = mpassword.getText().toString().trim();


        if (user != null) {
            String uid, uname, uemail;
            Uri photoUrl;
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                //String providerId = profile.getProviderId();

                // UID specific to the provider
                //String uid = profile.getUid();

                // Name, email address, and profile photo Url
                uname = profile.getDisplayName();
                uemail = profile.getEmail();
                photoUrl = profile.getPhotoUrl();

                // create user in the database
                postNewUser(email, password, uname, uname, String.valueOf(photoUrl), "M/F" );

            }
            // create user in the database
            ///postNewUser(email, password, uname, uname, String.valueOf(photoUrl), "M/F" );
        }



    }
}
