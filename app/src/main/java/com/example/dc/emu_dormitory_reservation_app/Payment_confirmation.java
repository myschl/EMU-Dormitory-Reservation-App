package com.example.dc.emu_dormitory_reservation_app;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivityDataModel;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class Payment_confirmation extends AppCompatActivity {

    private RequestQueue mQueue;
    private TextView mbookingNo, mroombook, mdormitoryname, mconfexpdate, mbookingDate, mbookingStatus;
    private Button muploadpayment;
    private ImageView muploadpaymentphoto;
    String pathToFile;

    Integer REQUEST_CAMERA=0, SELECT_FILE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirmation);
        Toolbar toolbar = (Toolbar)findViewById(R.id.payment_confirmation);
        toolbar.setTitle("Payment Confirmation");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Payment_confirmation.this, "Back Arrow Toolbar Image Icon Clicked", Toast.LENGTH_LONG).show();
                        // startActivity(new Intent(Terms_and_conditions.this,DebugActivity.class));
                        finish(); //this destroys current activity since startActivity starts an activity finish finishes an activity
                    }
                }

        );

        muploadpaymentphoto = findViewById(R.id.iuploadpaymentphoto);
        mbookingDate = findViewById(R.id.ibookingdate);
        mbookingNo = findViewById(R.id.ibookingnumber);
        mconfexpdate = findViewById(R.id.icomfirmationexperydate);
        mdormitoryname = findViewById(R.id.idormitoryname);
        mroombook = findViewById(R.id.iroombooked);
        mbookingStatus = findViewById(R.id.ibookingstatus);
        muploadpayment = findViewById(R.id.iuploadpayment);


        if (Build.VERSION.SDK_INT >= 23){
            requestPermissions(new String[]{android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }

        muploadpaymentphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });

        muploadpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Payment_confirmation.this);
                builder.setMessage("by clicking on continue your booking payment receipt will be process")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // handle the user after clicking on yes button
                                Toast.makeText(Payment_confirmation.this, "Your booking receipt is successful send", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Payment_confirmation.this, booking_tabbed_activity.class));
                            }
                        }).setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        //API call function
        MyBooking();


    }


    private void SelectImage(){
        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Payment_confirmation.this);
        builder.setTitle("Add Image From");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (items[which].equals("Camera")){
                    dispatchpictureTakerAction();

                }else if (items[which].equals("Gallery")){
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "SelectFile"), SELECT_FILE);

                }else if (items[which].equals("Cancel")){
                    dialog.dismiss();

                }
            }
        });
        builder.show();
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_CAMERA){
                Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);
                muploadpaymentphoto.setImageBitmap(bitmap);
            }
            else if (requestCode == SELECT_FILE){
                Uri selectedImage = data.getData();
                muploadpaymentphoto.setImageURI(selectedImage);
            }

        }
    }





    private void dispatchpictureTakerAction() {
        Intent takePict = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePict.resolveActivity(getPackageManager()) != null){
            File photoFile =null;
            photoFile = createPhotoFile();

            if (photoFile != null){
                pathToFile = photoFile.getAbsolutePath();
                Uri photoURI = FileProvider.getUriForFile(Payment_confirmation.this, "com.examples.android.fileprovider", photoFile);
                takePict.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePict, REQUEST_CAMERA);
            }
        }
    }

    private File createPhotoFile() {
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try{
            image = File.createTempFile(name, ".jpg", storageDir);
        }catch (IOException e){
            Log.d("mylog", "Excep :" + e.toString());
        }
        return image;
    }




    private void MyBooking() {
        String url = "http://35.204.232.129/api/BookingByBookingId/5";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject booking = response.getJSONObject("Body");

                                String PaymentComfirmationExpDate = booking.getString("paymentConfirmationExpiryDate");
                                String BookingStatus = booking.getString("BookingStatus");
                                String BookingDate = booking.getString("BookingDate");
                                String DormitoryId = booking.getString("DormitoryId");
                                String RomBooked = booking.getString("RoomBooked");
                                String DormitoryName = booking.getString("DormitoryName");
                                String BookingNumber = booking.getString("BookingNo");

                                mbookingDate.setText(BookingDate);
                                mconfexpdate.setText(PaymentComfirmationExpDate);
                                mbookingNo.setText(BookingNumber);
                                mroombook.setText(RomBooked);
                                mdormitoryname.setText(DormitoryName);
                                mbookingStatus.setText(BookingStatus);


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
        mQueue = Volley.newRequestQueue(Payment_confirmation.this);
        mQueue.add(request);
    }


}
