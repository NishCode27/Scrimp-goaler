package com.example.scrimp_goaler;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class PinPlaceActivity extends AppCompatActivity {
    ListView listView;
    static ArrayList<String> arrayList = new ArrayList<String>();
    static ArrayList<String> latitudeList = new ArrayList<String>();
    static ArrayList<String> longitudeList = new ArrayList<String>();
    static  ArrayAdapter<String> arrayAdapter;
    Button openmapBtn;

    //Pin Location App
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_place);
        openmapBtn = (Button) findViewById(R.id.openmapBtn);
        openmapBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent mapIntent = new Intent(getApplicationContext(),MapsActivity.class);
                        startActivity(mapIntent);
                    }

                }
        );

    }
}


