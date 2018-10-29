package com.example.dc.emu_dormitory_reservation_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;

import java.util.ArrayList;

public class Room_detail extends AppCompatActivity {
    private ArrayList fimage = new ArrayList();
    private ArrayList fname = new ArrayList();
    private Button mbookroom;
    ViewPager viewPager;
    int images[] = {R.drawable.akdeniz_1, R.drawable.akdeniz_2, R.drawable.akdeniz_3, R.drawable.akdeniz_2};
    MyCustomPagerAdapter myCustomPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        mbookroom = findViewById(R.id.ibookroom);
        Toolbar toolbar = (Toolbar)findViewById(R.id.room_detail);
        toolbar.setTitle("Room");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Room_detail.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        // booking dialog
        mbookroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Room_detail.this);
                builder.setMessage("Are you sure you want to book this room")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // handle the user after clicking on yes button
                        Toast.makeText(Room_detail.this, "Your booking is successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Room_detail.this, booking_tabbed_activity.class));
                    }
                }).setNegativeButton("No", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        Myfun();
        fRecycler();
    }

    private void fRecycler() {
        fimage.add("http://ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg");
        fname.add("wif");
        fimage.add("http://en.alfamcyprus.com/thumbnail.php?file=images/2.jpg&pwidth=1903&pheight=850&pw=475.7500&ph=212.5000&px=0.0000&py=0.0000&pscale=0.2500&pangle=0.0000&force=y");
        fname.add("Telephone");
        fimage.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        fname.add("TV");
        fimage.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        fname.add("Fridge");
        fimage.add("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg");
        fname.add("");
        fimage.add("http://ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg");
        fname.add("wif");
        fimage.add("http://en.alfamcyprus.com/thumbnail.php?file=images/2.jpg&pwidth=1903&pheight=850&pw=475.7500&ph=212.5000&px=0.0000&py=0.0000&pscale=0.2500&pangle=0.0000&force=y");
        fname.add("Telephone");
        fimage.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        fname.add("TV");

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.room_detail_recycleview);
        Room_detail_facilities_Adapter adapter = new Room_detail_facilities_Adapter(this, fimage,fname);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Room_detail.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);

    }

    private void Myfun() {
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(Room_detail.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
    }
}
