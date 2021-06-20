package com.cat.ceftriaxone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.cat.ceftriaxone.contraindications.Contraindications_fragment;
import com.cat.ceftriaxone.indications.Indications_fragment;
import com.cat.ceftriaxone.more.More_fragment;
import com.cat.ceftriaxone.pi.PI_fragment;
import com.cat.ceftriaxone.populations.Populations_fragment;
import com.cat.ceftriaxone.products.Products_fragment;
import com.cat.ceftriaxone.speciality.Speciality_fragment;
import com.cat.ceftriaxone.tips.Tips_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    int isHome = 1;

    public void setHome(int home) {
        isHome = home;
    }

    ImageView btm_nav_speciality, btm_nav_indications, btm_nav_products, btm_nav_populations, btm_nav_contraindications, btm_nav_tips, btm_nav_pi;

    public void setSpeciality() {
        if (bottomNavigationView.getSelectedItemId() != R.id.bottom_nav_bar_speciality) {
            bottomNavigationView.setSelectedItemId(R.id.bottom_nav_bar_speciality);
        }
    }


    public void setContentFragment(Fragment fragment, String fragmentName) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contentLayout, fragment);
        fragmentTransaction.addToBackStack(fragmentName);
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

        btm_nav_speciality.setOnClickListener(this);
        btm_nav_indications.setOnClickListener(this);
        btm_nav_products.setOnClickListener(this);
        btm_nav_populations.setOnClickListener(this);
        btm_nav_contraindications.setOnClickListener(this);
        btm_nav_tips.setOnClickListener(this);
        btm_nav_pi.setOnClickListener(this);

        bottomNavigationView = findViewById(R.id.btm_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



//        navigateToSpeciality();
        setContentFragment(new Speciality_fragment(), "");

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
//        SideNavigationHandler handler = new SideNavigationHandler(getBaseContext(), id);
//        handler.navigate();

        if (id == R.id.bottom_nav_bar_speciality) {
            navigateToSpeciality();
        } else if (id == R.id.bottom_nav_bar_indications) {
            navigateToIndications();
        } else if (id == R.id.bottom_nav_bar_products) {
            navigateToProducts();
        } else if (id == R.id.bottom_nav_bar_more) {
            navigateToMore();
        }else if (id == R.id.nav_population) {
            navigateToPopulation();
        } else if (id == R.id.nav_contraindications) {
            navigateToContraindications();
        } else if (id == R.id.nav_tips) {
            navigateToTips();
        } else if (id == R.id.nav_pi) {
            navigateToPI();
        }

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

    //Navigate To Speciality Tabs
    private void navigateToSpeciality() {
        setContentFragment(new Speciality_fragment(), "Speciality_fragment");
    }

    //Navigate To Indications Tabs
    private void navigateToIndications() {
        setContentFragment(new Indications_fragment(), "Indications_fragment");
    }

    //Navigate To Products Tabs
    private void navigateToProducts() {
        setContentFragment(new Products_fragment(), "Products_fragment");
    }

    //Navigate To More Tabs
    private void navigateToMore() {
        setContentFragment(new More_fragment(), "More_fragment");
    }

    //Navigate To Populations Tabs
    private void navigateToPopulation() {
        setContentFragment(new Populations_fragment(), "Populations_fragment");
    }

    //Navigate To Contraindications Tabs
    private void navigateToContraindications() {
        setContentFragment(new Contraindications_fragment(), "Contraindications_fragment");
    }

    //Navigate To Tips Tabs
    private void navigateToTips() {
        setContentFragment(new Tips_fragment(), "Tips_fragment");
    }

    //Navigate To PI Tabs
    private void navigateToPI() {
        setContentFragment(new PI_fragment(), "PI_fragment");
    }


    @Override
    public void onBackPressed() {
        if (isHome == 1){
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
        else if (isHome == 2){
            super.onBackPressed();
        }
        else {
            navigateToSpeciality();
        }

    }


}