package com.example.dc.emu_dormitory_reservation_app.Navigational_drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.dc.emu_dormitory_reservation_app.BookingbyCustomerId;
import com.example.dc.emu_dormitory_reservation_app.DebugActivity.DebugActivity;
import com.example.dc.emu_dormitory_reservation_app.Get_help;
import com.example.dc.emu_dormitory_reservation_app.Give_app_feedback_activity.Main2Activity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.bookingsDataModel;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.SearchResultsListDataModel;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.search_result_activity;
import com.example.dc.emu_dormitory_reservation_app.settings_activity.Setting;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class navigational_drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   protected DrawerLayout mDrawer;
   protected Toolbar mToolbar;
    private RequestQueue mQueue;
   private ImageView nav_image;
   private TextView textView_nav_username;
    private FirebaseAuth firebaseAuth;
    private ArrayList<BookingbyCustomerId> alldorms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigational_drawer);
textView_nav_username = findViewById(R.id.nav_username);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Home");
        setSupportActionBar(mToolbar);

        nav_image = findViewById(R.id.nav_image);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {

            FirebaseUser user = firebaseAuth.getCurrentUser();
           /* Glide.with(this).asBitmap().load(firebaseAuth.getCurrentUser().getPhotoUrl()).into(nav_image);

            textView_nav_username.setText(firebaseAuth.getCurrentUser().getDisplayName());*/

        }

        DormitoriesAPI();


        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void DormitoriesAPI() {
        String url = "http://35.204.232.129/api/GetBookingsByCustomerId/5";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("Body");

                            JSONArray JA = JO.getJSONArray("Bookings");

                            for (int i=0; i<JA.length(); i++){

                                JSONObject booking = JA.getJSONObject(i);
                                String DormitoryDescription = booking.getString("DormitoryDescription");
                                String DormitoryId = booking.getString("DormitoryId");
                                String Dormitoryname = booking.getString("Dormitoryname");
                                String PictureUrl = booking.getString("PictureUrl");
                                String RatingNumber = booking.getString("RatingNumber");
                                String RatingText = booking.getString("RatingText");
                                String BookingDate = booking.getString("BookingDate");
                                String CheckInDate = booking.getString("CheckInDate");
                                String BookingStatus = booking.getString("BookingStatus");

                                alldorms.add(new BookingbyCustomerId(Dormitoryname, DormitoryDescription, BookingDate, CheckInDate, BookingStatus,PictureUrl,RatingNumber,RatingText));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue = Volley.newRequestQueue(navigational_drawer.this);
        mQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigational_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(navigational_drawer.this, Setting.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bookings) {
            // Handle the booking action action
            Intent i=new Intent(navigational_drawer.this,booking_tabbed_activity.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("alldorms",alldorms);
            i.putExtras(bundle);
            startActivity(i);
        } else if (id == R.id.nav_notifications) {
            //startActivity(new Intent(navigational_drawer.this, booking_tabbed_activity.class));
            Toast.makeText(navigational_drawer.this, "Up comming feature", Toast.LENGTH_SHORT).show();
        } /*else if (id == R.id.nav_saved_items) {
            startActivity(new Intent(navigational_drawer.this, booking_tabbed_activity.class));
        } else if (id == R.id.nav_deals) {
            startActivity(new Intent(navigational_drawer.this, booking_tabbed_activity.class));
        } else if (id == R.id.nav_coupons) {
            startActivity(new Intent(navigational_drawer.this, booking_tabbed_activity.class));
        } else if (id == R.id.nav_recently_viewd) {
            startActivity(new Intent(navigational_drawer.this, booking_tabbed_activity.class));
        }*/else if(id == R.id.nav_debug){
            startActivity(new Intent(navigational_drawer.this, DebugActivity.class));
        }else if (id == R.id.nav_settings){
            startActivity(new Intent(navigational_drawer.this, Setting.class));
        }else if(id == R.id.nav_help_center){
            startActivity(new Intent(navigational_drawer.this, Get_help.class));
        }else if (id == R.id.nav_share){
            //startActivity(new Intent(navigational_drawer.this, Setting.class));
            Toast.makeText(navigational_drawer.this, "Up comming feature", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.nav_Appfeedback){
            startActivity(new Intent(navigational_drawer.this, Main2Activity.class));
        }


        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
