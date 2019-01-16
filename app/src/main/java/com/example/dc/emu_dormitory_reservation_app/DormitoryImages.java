package com.example.dc.emu_dormitory_reservation_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DormitoryImages extends AppCompatActivity {

    private RequestQueue mQueue;

    private ArrayList<DormitoryImagesModel> mImageUrl = new ArrayList<>();
    private String dormId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dormitory_images);


        Bundle bundle = getIntent().getExtras();
        dormId = bundle .getString("DormId");

        /*Bundle bundleobje=getIntent().getExtras();
        mImageUrl=(ArrayList<DormitoryImagesModel>) bundleobje.getSerializable("DormImages");*/

        DormitoryDetailsApi();

    }

    private void DormitoryDetailsApi() {

        /*Bundle bundle = getIntent().getExtras();
        String dormId = bundle .getString("DormId");*/
        String url = "http://35.204.232.129/api/GetDormitoryDetailById/"+dormId;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject JO = response.getJSONObject("body");

                            //Room id, qota and price
                            String domname = JO.getString("dormitoryname");
                            String dormshortdescription = JO.getString("dormitoryShortDescription");
                            String dormitotyfulldescription = JO.getString("dormitotyFullDescription");
                            String dormpolicies = JO.getString("dormitoryPolicies");



                            // for facilities
                            JSONArray JAI = JO.getJSONArray("facilitiesList");

                            for (int i=0; i<JAI.length(); i++) {
                                JSONObject facility = JAI.getJSONObject(i);
                                String image = facility.getString("pictureUrl");
                                String name = facility.getString("facilityname");
                                String facilityId = facility.getString("facilityId");

                            }



                            // for images
                            JSONArray JA = JO.getJSONArray("imageUrls");
                            for (int i=0; i<JA.length(); i++){
                                String picture = JA.getString(i);
                                mImageUrl.add(new DormitoryImagesModel(picture));

                            }
                            initRecyclerview();

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
        mQueue = Volley.newRequestQueue(DormitoryImages.this);
        mQueue.add(request);
    }

    private void initRecyclerview() {

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.iimagerecyclerview);
        DormitoryImagesAdapter adapter = new DormitoryImagesAdapter(DormitoryImages.this, mImageUrl);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(DormitoryImages.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
    }
}
