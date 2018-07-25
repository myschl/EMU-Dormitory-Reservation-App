package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Myfun();
    }

    private void Myfun() {
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash_screen.this, DebugActivity.class));
                finish();
            }
        }, secondsDelayed * 6000);


        // image gif
        /*ImageView image =(ImageView)findViewById(R.id.image_gif);
        Ion.with(image).load("https://i.gifer.com/7pla.gif");*/
    }
}
