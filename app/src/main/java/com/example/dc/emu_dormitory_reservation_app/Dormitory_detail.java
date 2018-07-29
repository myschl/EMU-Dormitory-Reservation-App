package com.example.dc.emu_dormitory_reservation_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class Dormitory_detail extends AppCompatActivity {
    private ArrayList<String>mImageUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dormitory_detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.dormitory_detail);
        toolbar.setTitle("");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);

        initImageBitmaps();
    }

    private void initImageBitmaps() {
        mImageUrl.add("http://ww1.emu.edu.tr/emu_v1/media/posts_media/media_1706_en_1200.jpg");
        mImageUrl.add("http://en.alfamcyprus.com/thumbnail.php?file=images/2.jpg&pwidth=1903&pheight=850&pw=475.7500&ph=212.5000&px=0.0000&py=0.0000&pscale=0.2500&pangle=0.0000&force=y");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");
        mImageUrl.add("https://en.kibrisyurtlar.com/thumbnail.php?file=images/odalar/oda1.jpg");
        mImageUrl.add("https://tr.alfamcyprus.com/thumbnail.php?file=pics/pics_blog/HBR_81349/edaa2aba35021ef3f1d9aa9f478443a0.jpg&pwidth=370&pheight=235");

        initRecyclerview();
    }

    private void initRecyclerview() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        Dormitory_detail_Adapter adapter = new Dormitory_detail_Adapter(this, mImageUrl);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Dormitory_detail.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
    }
}
