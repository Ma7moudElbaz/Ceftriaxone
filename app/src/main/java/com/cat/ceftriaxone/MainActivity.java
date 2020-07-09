package com.cat.ceftriaxone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.cat.ceftriaxone.contraindications.Contraindications_fragment;
import com.cat.ceftriaxone.indications.Indications_fragment;
import com.cat.ceftriaxone.pi.PI_fragment;
import com.cat.ceftriaxone.populations.Populations_fragment;
import com.cat.ceftriaxone.products.Products_fragment;
import com.cat.ceftriaxone.speciality.Speciality_fragment;
import com.cat.ceftriaxone.tips.Tips_fragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    NavigationView navigationView;
    ImageView menuIcon;
    DrawerLayout drawer;
    Menu nav_Menu;

    ImageView btm_nav_speciality, btm_nav_indications, btm_nav_products, btm_nav_populations, btm_nav_contraindications, btm_nav_tips, btm_nav_pi;


    public void setContentFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contentLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btm_nav_speciality = findViewById(R.id.btm_nav_speciality);
        btm_nav_indications = findViewById(R.id.btm_nav_indications);
        btm_nav_products = findViewById(R.id.btm_nav_products);
        btm_nav_populations = findViewById(R.id.btm_nav_populations);
        btm_nav_contraindications = findViewById(R.id.btm_nav_contraindications);
        btm_nav_tips = findViewById(R.id.btm_nav_tips);
        btm_nav_pi = findViewById(R.id.btm_nav_pi);

        menuIcon = findViewById(R.id.menu);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        btm_nav_speciality.setOnClickListener(this);
        btm_nav_indications.setOnClickListener(this);
        btm_nav_products.setOnClickListener(this);
        btm_nav_populations.setOnClickListener(this);
        btm_nav_contraindications.setOnClickListener(this);
        btm_nav_tips.setOnClickListener(this);
        btm_nav_pi.setOnClickListener(this);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(this);

        nav_Menu = navigationView.getMenu();

        navigateToSpeciality();

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btm_nav_speciality) {
            navigateToSpeciality();
        } else if (v.getId() == R.id.btm_nav_indications) {
            navigateToIndications();
        } else if (v.getId() == R.id.btm_nav_products) {
            navigateToProducts();
        } else if (v.getId() == R.id.btm_nav_populations) {
            navigateToPopulation();
        } else if (v.getId() == R.id.btm_nav_contraindications) {
            navigateToContraindications();
        } else if (v.getId() == R.id.btm_nav_tips) {
            navigateToTips();
        } else if (v.getId() == R.id.btm_nav_pi) {
            navigateToPI();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        SideNavigationHandler handler = new SideNavigationHandler(getBaseContext(), id);
        handler.navigate();

        if (id == R.id.nav_speciality) {
            navigateToSpeciality();
        } else if (id == R.id.nav_indications) {
            navigateToIndications();
        } else if (id == R.id.nav_products) {
            navigateToProducts();
        } else if (id == R.id.nav_population) {
            navigateToPopulation();
        } else if (id == R.id.nav_contraindications) {
            navigateToContraindications();
        } else if (id == R.id.nav_tips) {
            navigateToTips();
        } else if (id == R.id.nav_pi) {
            navigateToPI();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setBottomNavSelected(View id) {
        btm_nav_speciality.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_nav_bg, getTheme()));
        btm_nav_indications.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_nav_bg, getTheme()));
        btm_nav_products.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_nav_bg, getTheme()));
        btm_nav_populations.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_nav_bg, getTheme()));
        btm_nav_contraindications.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_nav_bg, getTheme()));
        btm_nav_tips.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_nav_bg, getTheme()));
        btm_nav_pi.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_nav_bg, getTheme()));

        id.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme()));
    }

    private void navigateToSpeciality() {
        setContentFragment(new Speciality_fragment());
        navigationView.setCheckedItem(R.id.nav_speciality);
        setBottomNavSelected(btm_nav_speciality);

    }

    private void navigateToIndications() {
        setContentFragment(new Indications_fragment());
        navigationView.setCheckedItem(R.id.nav_speciality);
        setBottomNavSelected(btm_nav_indications);
    }

    private void navigateToProducts() {
        setContentFragment(new Products_fragment());
        navigationView.setCheckedItem(R.id.nav_products);
        setBottomNavSelected(btm_nav_products);
    }

    private void navigateToPopulation() {
        setContentFragment(new Populations_fragment());
        navigationView.setCheckedItem(R.id.nav_population);
        setBottomNavSelected(btm_nav_populations);
    }

    private void navigateToContraindications() {
        setContentFragment(new Contraindications_fragment());
        navigationView.setCheckedItem(R.id.nav_contraindications);
        setBottomNavSelected(btm_nav_contraindications);
    }

    private void navigateToTips() {
        setContentFragment(new Tips_fragment());
        navigationView.setCheckedItem(R.id.nav_tips);
        setBottomNavSelected(btm_nav_tips);
    }

    private void navigateToPI() {
        setContentFragment(new PI_fragment());
        navigationView.setCheckedItem(R.id.nav_pi);
        setBottomNavSelected(btm_nav_pi);
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Are you sure you want to exit ? ")
//                    .setMessage("You have to login first")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                            finish();
                        }
                    })
                    .setNegativeButton("Dismiss", null)
                    .show();
        }
    }


}