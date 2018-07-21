package com.example.dc.emu_dormitory_reservation_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DebugActivity extends AppCompatActivity {
    ListView listViewDebug;
    ArrayAdapter adapter;
    //////////////////////
    //
    // Write the name of the new activity  in this array
    //////////////////////

    String Activities[] ={"Create_Account Activity",
                            "Edit_booking Activity",
    "Main2Activity",
    "MainActivity",
    "Manage_booking",
    "Sign_in",
    "Sign_in_with_email",
    "Sign_in_with_student_no",
    "Terms_and_conditions",
    "Filter_by",
    "Setting",
    "Rate_your_stay",
    "Facilities_filters",
    "Get_help"};

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
                        startActivity(new Intent(DebugActivity.this,Facilities_filters.class));break;
                    case 13:
                        startActivity(new Intent(DebugActivity.this,Get_help.class));break;

                }

            }
        });

    }
}
