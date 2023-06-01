package com.example.scrimp_goaler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetGoalActivity extends AppCompatActivity {
    DBHelper DB;
    EditText goalValue, description, period, startDate;
    Button setGoal, viewGoal, homeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);

        DB = new DBHelper(this);
        goalValue = (EditText) findViewById(R.id.textInputEditText);
        description = (EditText) findViewById(R.id.editText);
        period = (EditText) findViewById(R.id.editText2);
        startDate = (EditText) findViewById(R.id.editText3);
        setGoal = (Button) findViewById(R.id.button2);
        viewGoal = (Button) findViewById(R.id.button);
        homeScreen = (Button) findViewById(R.id.button3);


        insertGoals();
        viewAll();
        goHome();
    }

    public void insertGoals() {
        setGoal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = DB.insertGoals(goalValue.getText().toString(),
                                description.getText().toString(), period.getText().toString(), startDate.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(SetGoalActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SetGoalActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }

    public void viewAll() {
        viewGoal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor results = DB.getAllData();
                        if (results.getCount() == 0) {
                            showMessage("Error message : ", "No data found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (results.moveToNext()) {
                            buffer.append("goalvalue:" + results.getString(0) + "\n");
                            buffer.append("description:" + results.getString(1) + "\n");
                            buffer.append("period:" + results.getString(2) + "\n");
                            buffer.append("startdate:" + results.getString(3) + "\n");

                            showMessage("List of Data: ", buffer.toString());

                        }
                    }


                }
        );
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void goHome(){
        homeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });
    }
}






