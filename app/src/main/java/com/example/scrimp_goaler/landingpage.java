package com.example.scrimp_goaler;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class landingpage extends AppCompatActivity {
    EditText name;
    Button insert;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);

        name = findViewById(R.id.editTextTextPersonName);
        insert = findViewById(R.id.button2);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxT = name.getText().toString();

                Boolean checkinsertdata = DB.insertUserdata(nameTxT);
                if(checkinsertdata==true)
                    Toast.makeText(landingpage.this,"Entered username",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(landingpage.this,"No name entered",Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Cursor res = DB.getUserdata();
                if (res.getCount()==0);
                Toast.makeText(landingpage.this, "No entry exists", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(res.moveToNext()){
                buffer.append("Name :"+res.getString(0)+"n")
            }
        }

    }
}