package com.example.dc.emu_dormitory_reservation_app.DebugActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dc.emu_dormitory_reservation_app.About_us_activity.MainActivity;
import com.example.dc.emu_dormitory_reservation_app.Create_account_activity.Create_Account;
import com.example.dc.emu_dormitory_reservation_app.Home_activity.HomeActivity;
import com.example.dc.emu_dormitory_reservation_app.booking_activity.booking_tabbed_activity;
import com.example.dc.emu_dormitory_reservation_app.edit_booking_activity.Edit_booking;
import com.example.dc.emu_dormitory_reservation_app.Filter_by_activity.Filter_by;
import com.example.dc.emu_dormitory_reservation_app.Give_app_feedback_activity.Main2Activity;
import com.example.dc.emu_dormitory_reservation_app.manage_booking_activity.Manage_booking;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Sign_in_activity.Sign_in;
import com.example.dc.emu_dormitory_reservation_app.Terms_and_conditions_activity.Terms_and_conditions;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_1.rate_bookings_activity_1;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsActivity2;
import com.example.dc.emu_dormitory_reservation_app.rate_your_stay_activity.Rate_your_stay;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.search_result_activity;
import com.example.dc.emu_dormitory_reservation_app.settings_activity.Setting;
import com.example.dc.emu_dormitory_reservation_app.sign_in_with_email_activity.Sign_in_with_Email;
import com.example.dc.emu_dormitory_reservation_app.sign_in_with_student_no_activity.Sign_in_with_student_No;

public class DebugActivity extends AppCompatActivity {
    ListView listViewDebug;
    ArrayAdapter adapter;
    //////////////////////
    //
    // Write the name of the new activity  in this array
    //////////////////////

    String Activities[] ={"Create_Account Activity",
                            "Edit_booking Activity",
    "Give_app_feedback",
    "About us",
    "Manage_booking",
    "Sign_in",
    "Sign_in_with_email",
    "Sign_in_with_student_no",
    "Terms_and_conditions",
    "Filter_by",
    "Setting",
    "Rate_your_stay",

    "Rate_bookings_activity_1",
    "Rate_bookings_activity_2_with_images",
            "booking_tabbed_activity",
            "search_results_activity",
            "Home Activity"
   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        listViewDebug = (ListView) findViewById(R.id.listViewDebug);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Activities);

        listViewDebug.setAdapter(adapter);
        listViewDebug.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /////////////////////////
                //
                //Add the new activity navigation to the end of this switch
                // case n+1:
                // startActivity(new Intent(DebugActivity.this,name_of_activity.class));break;
                //This will add the activity to the debuglist
                /////////////////////////
                switch(position){
                    case 0:
                        startActivity(new Intent(DebugActivity.this,Create_Account.class));break;
                    case 1:
                        startActivity(new Intent(DebugActivity.this,Edit_booking.class));break;
                    case 2:
                        startActivity(new Intent(DebugActivity.this,Main2Activity.class));break;
                    case 3:
                        startActivity(new Intent(DebugActivity.this,MainActivity.class));break;
                    case 4:
                        startActivity(new Intent(DebugActivity.this,Manage_booking.class));break;
                    case 5:
                        startActivity(new Intent(DebugActivity.this,Sign_in.class));break;
                    case 6:
                        startActivity(new Intent(DebugActivity.this,Sign_in_with_Email.class));break;
                    case 7:
                        startActivity(new Intent(DebugActivity.this,Sign_in_with_student_No.class));break;
                    case 8:
                        startActivity(new Intent(DebugActivity.this,Terms_and_conditions.class));break;
                    case 9:
                        startActivity(new Intent(DebugActivity.this,Filter_by.class));break;
                    case 10:
                        startActivity(new Intent(DebugActivity.this,Setting.class));break;
                    case 11:
                        startActivity(new Intent(DebugActivity.this,Rate_your_stay.class));break;
                    case 12:
                        startActivity(new Intent(DebugActivity.this,rate_bookings_activity_1.class));break;
                    case 13:
                        startActivity(new Intent(DebugActivity.this,RateBookingsActivity2.class));break;
                    case 14:
                        startActivity(new Intent(DebugActivity.this,booking_tabbed_activity.class));break;
                    case 15:
                        startActivity(new Intent(DebugActivity.this,search_result_activity.class));break;
                     case 16:
                        startActivity(new Intent(DebugActivity.this,HomeActivity.class));break;



                }

            }
        });

    }
}
