package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dormitory_detail extends AppCompatActivity {
    private RequestQueue mQueue;
    private ArrayList<String>mImageUrl = new ArrayList<>();
    private Button mchooseroom;
    private TextView mdormitorypolicies,mexpandableTextView, mfacilities, mdormpoliciestext, mdormnane, mdormshortdescription;
    //private ExpandableTextView mexpandableTextView;
    private ExpandableLayout mdormfacilitie, mdormpolicies;
    private String FullDescription;
    private ArrayList<DormitoryDetailFacilitiesModel> dormfacilities = new ArrayList<>();
    private ArrayList<Choose_room_class> DormitoryRooms = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dormitory_detail);

        //FullDescription = "Dan Fodio was a Fulani descendant of a torodbe family that was well established in Hausaland.[9][10] He was well educated in classical Islamic science, philosophy, and theology. He also became a revered religious thinker. His teacher, Jibril ibn 'Umar, argued that it was the duty and within the power of religious movements to establish an ideal society free from oppression and vice. Jibril was a North African Muslim alim who gave his apprentice a broader perspective of Muslim reformist ideas in other parts of the Muslim world. Jibril b. Umar was known as an uncompromising opponent of corrupt practices and a stuanch proponent of Jihad. He begain his intinerant preaching as a mallam in 1774-1775. Inspired by Jibril b. Umar, Uthman Dan Fodio criticized the Hausa Kingdoms for their unjust and illegal taxes, confiscations of property, compulsory military service, bribery, gift taking and the enslavement of other Muslims. Dan Fodio also criticized the Hausa rulers for condoning paganism, worshipping fetishes, and believing in the power of talismans, divination, and conjuring. He also insisted on the observance of Maliki Law in the commercial, criminal, and personal sectors. Uthman also denounced the mixing of men and women, pagan customs, dancing at bridal feasts, and inheritance practices contrary to Islamic Law.";

        Toolbar toolbar = (Toolbar)findViewById(R.id.dormitory_detail);
        toolbar.setTitle("");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);

        mchooseroom = findViewById(R.id.ichooseroom);
        mdormitorypolicies = findViewById(R.id.idormpoliciestext);
        //mfacilities = findViewById(R.id.ifacilities);
        mexpandableTextView = findViewById(R.id.expandable_text);
        mdormnane = findViewById(R.id.idormname);
        mdormshortdescription = findViewById(R.id.idormshortdescription);

        ExpandableText();

        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Dormitory_detail.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );
        mchooseroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Dormitory_detail.this,Choose_room.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("allrooms",DormitoryRooms);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

       /* mfacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dormitory_detail.this, Facilities_filters.class));
            }
        });
        mdormitorypolicies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Dormitory_detail.this, Choose_room.class));
                Toast.makeText(Dormitory_detail.this, "Up comming feature", Toast.LENGTH_SHORT).show();
            }
        });*/




        //initImageBitmaps();
        DormitoryDetailsApi();
        DormitoryRoomss();
    }

    private void DormitoryRoomss() {
        String url = "http://35.204.232.129/api/GetRoomByDormitoryId/5";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("Body");


                            // for Rooms
                            JSONArray JAI = JO.getJSONArray("Rooms");

                            for (int i=0; i<JAI.length(); i++) {
                                JSONObject rooms = JAI.getJSONObject(i);
                                String image = rooms.getString("pictureUrl");
                                String name = rooms.getString("dormitoryName");
                                String bedtype = rooms.getString("bedType");
                                String roomsize = rooms.getString("roomSize");
                                String roomqota = rooms.getString("roomQuotaRemaining");
                                String roomPrice = rooms.getString("RoomPrice");
                                String roomid = rooms.getString("RoomId");
                                String dormid = rooms.getString("DormitoryId");
                                DormitoryRooms.add(new Choose_room_class(image, name, bedtype, roomsize, roomqota, roomPrice));
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
        mQueue = Volley.newRequestQueue(Dormitory_detail.this);
        mQueue.add(request);
    }

    private void DormitoryDetailsApi() {

        String url = "https://api.myjson.com/bins/8r2gy";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("Body");

                            //Room id, qota and price
                            String domname = JO.getString("Dormitoryname");
                            String dormshortdescription = JO.getString("DormitoryShortDescription");
                            String dormitotyfulldescription = JO.getString("DormitotyFullDescription");
                            String dormpolicies = JO.getString("DormitoryPolicies");

                            //mexpandableTextView.setText(dormitotyfulldescription);
                            FullDescription = dormitotyfulldescription;
                            mdormitorypolicies.setText(dormpolicies);
                            mdormnane.setText(domname);
                            mdormshortdescription.setText(dormshortdescription);

                            ExpandableText();


                            // for facilities
                            JSONArray JAI = JO.getJSONArray("FacilitiesList");

                            for (int i=0; i<JAI.length(); i++) {
                                JSONObject facility = JAI.getJSONObject(i);
                                String image = facility.getString("pictureUrl");
                                String name = facility.getString("facilityname");
                                String facilityId = facility.getString("facilityId");
                                dormfacilities.add(new DormitoryDetailFacilitiesModel(image, name, facilityId));
                            }


                            // for images
                            JSONArray JA = JO.getJSONArray("ImageUrls");
                            for (int i=0; i<JA.length(); i++){
                                String picture = JA.getString(i);
                                mImageUrl.add(picture);
                                initRecyclerview();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        /*try {
                            JSONObject JO = response.getJSONObject("Body");


                           *//* // for facilities
                            JSONArray JAI = JO.getJSONArray("FacilitiesList");

                            for (int i=0; i<JAI.length(); i++){
                                JSONObject facility = JAI.getJSONObject(i);
                                String image = facility.getString("pictureUrl");
                                String name = facility.getString("facilityname");
                                String facilityId = facility.getString("facilityId");
                                dormfacilities.add(new DormitoryDetailFacilitiesModel(image, name, facilityId));*//*
                            }*/
                            //for images
                            /*JSONArray JA = JO.getJSONArray("ImageUrls");

                            for (int i=0; i<JA.length(); i++){
                                String picture = JA.getString(i);
                                mImageUrl.add(picture);
                                initRecyclerview();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue = Volley.newRequestQueue(Dormitory_detail.this);
        mQueue.add(request);
    }

    private void ExpandableText() {
        // sample code snippet to set the text content on the ExpandableTextView
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.expand_text_view);
        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expTv1.setText(FullDescription);
    }

  /*  private void initImageBitmaps() {
       *//* mImageUrl.add("http://ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg");
        mImageUrl.add("http://en.alfamcyprus.com/thumbnail.php?file=images/2.jpg&pwidth=1903&pheight=850&pw=475.7500&ph=212.5000&px=0.0000&py=0.0000&pscale=0.2500&pangle=0.0000&force=y");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("http://ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg");
        mImageUrl.add("http://en.alfamcyprus.com/thumbnail.php?file=images/2.jpg&pwidth=1903&pheight=850&pw=475.7500&ph=212.5000&px=0.0000&py=0.0000&pscale=0.2500&pangle=0.0000&force=y");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("http://ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg");
        mImageUrl.add("http://en.alfamcyprus.com/thumbnail.php?file=images/2.jpg&pwidth=1903&pheight=850&pw=475.7500&ph=212.5000&px=0.0000&py=0.0000&pscale=0.2500&pangle=0.0000&force=y");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
*//*
        initRecyclerview();
    }*/

    private void initRecyclerview() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        Dormitory_detail_Adapter adapter = new Dormitory_detail_Adapter(this, mImageUrl);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Dormitory_detail.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
    }

    public void DormitoryPolicies(View view) {

        mdormpoliciestext = findViewById(R.id.idormpoliciestext);
        mdormpolicies = findViewById(R.id.expandableLayout1);
        mdormpolicies.toggle();

    }

    public void DormitoryFacilities(View view) {


       /* dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
        dormfacilities.add(new DormitoryDetailFacilitiesModel("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg", "Wifi"));
*/
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.idormfacilitiesrecycleview);
        DormitoryDetailFacilityAdapter adapter = new DormitoryDetailFacilityAdapter(Dormitory_detail.this, dormfacilities);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager verticalLayoutManagaer = new LinearLayoutManager(Dormitory_detail.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManagaer);

        mdormfacilitie = findViewById(R.id.idormfacilities);
        mdormfacilitie.toggle();

    }

   /* public void chooseYourRoom(View view) {
        Intent i=new Intent(Dormitory_detail.this,Choose_room.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("allrooms",DormitoryRooms);
        i.putExtras(bundle);
        startActivity(i);
    }*/

  /*  public void ChooseYourRoom(View view) {
        Intent i=new Intent(Dormitory_detail.this,Choose_room.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("allrooms",DormitoryRooms);
        i.putExtras(bundle);
        startActivity(i);
    }*/

   /* @Override
    public void onClick(View v) {
        if (v == mchooseroom){
            // goto choose room
            startActivity(new Intent(this, Choose_room.class));
        }
        if (v == mfacilities){
            // dormitory facilities
            startActivity(new Intent(this, Facilities_filters.class));
        }
        if (v == mdormitorypolicies){
            //dissplay the dormitory policies
        }
    }*/
}
