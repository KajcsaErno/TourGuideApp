package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        NavigationView mNavigationView = findViewById(R.id.navigation_view);
                mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragment = null;

                if (menuItem.isChecked()) {

                    menuItem.setChecked(true);
                } else {
                    menuItem.setChecked(false);
                }


                switch (menuItem.getItemId()){
                    case(R.id.nav_home):
                        fragment = new HomeFragment();
                        break;

                    case (R.id.nav_timisoara):
                        fragment = new TimisoaraFragment();
                        break;

                    case (R.id.nav_sibiu):
                        fragment = new SibiuFragment();
                        break;

                    case (R.id.nav_cluj):
                        fragment = new ClujFragment();
                        break;

                    case(R.id.nav_brasov):
                        fragment = new BrasovFragment();
                        break;

                    case(R.id.nav_bucharest):
                        fragment = new BucharestFragment();
                        break;

                    case(R.id.nav_sighisoara):
                        fragment = new SighisoaraFragment();
                        break;

                    case(R.id.nav_iasi):
                        fragment = new IasiFragment();
                        break;

                    case(R.id.nav_constanta):
                        fragment = new ConstantaFragment();
                        break;

                }


               if (fragment != null ) {
                   FragmentManager fragmentManager =  getSupportFragmentManager();
                   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                   fragmentTransaction.replace(R.id.screen_area_frame_layout, fragment);
                   fragmentTransaction.commit();
               }  else {
                   // error in creating fragment
                   Log.e("MainActivity", "Error in creating fragment");
               }

                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;

            }
        });

    }

        @Override
        //when any item form action bar is tapped
    public boolean onOptionsItemSelected(MenuItem item) {


        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
