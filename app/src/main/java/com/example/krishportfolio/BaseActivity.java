package com.example.krishportfolio;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class BaseActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        drawerLayout = findViewById(R.id.mydrawerlayout);
        navigationView = findViewById(R.id.mynavigationview);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);

        // Ensure icons in the navigation drawer retain their original color
        navigationView.setItemIconTintList(null);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);


        // Handle Navigation View item clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.bio) {
                viewPager.setCurrentItem(0);
            } else if (id == R.id.skill) {
                viewPager.setCurrentItem(1);
            } else if (id == R.id.project) {
                viewPager.setCurrentItem(2);
            } else if (id == R.id.eduction) { // Ensure this ID matches your XML file
                viewPager.setCurrentItem(3);
            } else if (id == R.id.contact) {
                viewPager.setCurrentItem(4);
            } else {
                return false; // Return false if the ID doesn't match any known case
            }

            drawerLayout.closeDrawer(GravityCompat.START); // Close the navigation drawer after an item is selected
            return true;
        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            // Close the navigation drawer if it's open
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            // Show the exit confirmation dialog if the drawer is not open
            showExitDialog();
        }
    }

    private void showExitDialog() {
        AlertDialog.Builder alertDialong = new AlertDialog.Builder(BaseActivity.this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false) // Prevents the dialog from being dismissed by tapping outside it
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Close all activities and exit the app
                        finishAffinity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Just dismiss the dialog
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}