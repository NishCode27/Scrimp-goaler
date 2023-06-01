package com.example.scrimp_goaler;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        NavigationView navigationView = (NavigationView) findViewById(R.id.homenav);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_closed);
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
//                DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) drawerLayout.getLayoutParams();
//                params.height = (int) (500);
//                drawerLayout.setLayoutParams(params);
                switch (item.getItemId()) {

                    case R.id.nav_home:
                        Intent homeIntent = new Intent(getApplicationContext(), SignUpActivity.class);
                        startActivity(homeIntent);
//                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_Goal:
                        Intent goalIntent = new Intent(getApplicationContext(), SetGoalActivity.class);
                        startActivity(goalIntent);
//                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_Map:
                        Intent MapIntent = new Intent(getApplicationContext(), PinPlaceActivity.class);
                        startActivity(MapIntent);
//                        drawerLayout.closeDrawers();
                        break;
//                    case R.id.nav_setting:
////                        Intent settingsIntent = new Intent(getApplicationContext(), settings.class);
////                        startActivity(settingsIntent);
////                        drawerLayout.closeDrawers();



                }
                return false;
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

//        actionBarDrawerToggle.syncState();
    }
}
