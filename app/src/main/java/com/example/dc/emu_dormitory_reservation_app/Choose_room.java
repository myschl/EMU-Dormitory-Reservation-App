package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;

import java.util.ArrayList;

public class Choose_room extends AppCompatActivity {
    RecyclerView recyclerView;
    Choose_room_Adapter choose_room_adapter;
    ArrayList<Choose_room_class> recycle_items = new ArrayList<>();
    ArrayList<Choose_room_class> RoomDetailList = new ArrayList<>();
    private Button mselectRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_room);
        Toolbar toolbar = (Toolbar)findViewById(R.id.choose_room);
        toolbar.setTitle("Choose Room");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Choose_room.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

     /*   mselectRoom = findViewById(R.id.choose_room_select);
        mselectRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Choose_room.this,Room_detail.class);
             *//*   Bundle bundle=new Bundle();
                bundle.putSerializable("allrooms",RoomDetailList);
                i.putExtras(bundle);*//*
                startActivity(i);
            }
        });*/


        Bundle bundleobje = getIntent().getExtras();
        recycle_items=(ArrayList<Choose_room_class>) bundleobje.getSerializable("allrooms");

        MyFun();
        //RoomDetailAPI();

    }

   /* private void RoomDetailAPI() {

    }*/

    private void MyFun() {
        recyclerView = (RecyclerView)findViewById(R.id.choose_room_recycleview);
        //recyclerView.setHasFixedSize(true);


      /*  recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1277.jpg?RenditionID=7", "Akdeniz Single Room","1 single bed", "55m", "100 rooms left","$4500"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1268.jpg?RenditionID=7", "Akdeniz Double Room","2 single bed", "35m", "200 rooms left","$4000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1281.jpg?RenditionID=7", "Akdeniz Room","2 single bed", "25m", "0 rooms left","$6000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1250.jpg?RenditionID=7", "Akdeniz Single Room","2 single bed", "45m", "300 rooms left","$5000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1277.jpg?RenditionID=7", "Akdeniz Single Room","1 single bed", "55m", "100 rooms left","$4500"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1268.jpg?RenditionID=7", "Akdeniz Double Room","2 single bed", "35m", "200 rooms left","$4000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1281.jpg?RenditionID=7", "Akdeniz Room","2 single bed", "25m", "0 rooms left","$6000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1277.jpg?RenditionID=7", "Akdeniz Single Room","1 single bed", "55m", "100 rooms left","$4500"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1268.jpg?RenditionID=7", "Akdeniz Double Room","2 single bed", "35m", "200 rooms left","$4000"));
        recycle_items.add(new Choose_room_class("https://dormitories.emu.edu.tr/PhotoGalleries/dormitories/2016/akdeniz/img_1281.jpg?RenditionID=7", "Akdeniz Room","2 single bed", "25m", "0 rooms left","$6000"));
*/

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        choose_room_adapter=new Choose_room_Adapter(Choose_room.this,recycle_items);
        recyclerView.setAdapter(choose_room_adapter);


    }
}
