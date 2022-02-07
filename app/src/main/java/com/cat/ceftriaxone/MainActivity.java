package com.cat.ceftriaxone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.anirudh.locationfetch.EasyLocationFetch;
import com.anirudh.locationfetch.GeoLocationModel;
import com.cat.ceftriaxone.contraindications.Contraindications_fragment;
import com.cat.ceftriaxone.indications.Indications_fragment;
import com.cat.ceftriaxone.more.More_fragment;
import com.cat.ceftriaxone.network.Webservice;
import com.cat.ceftriaxone.notifications.NotificationsActivity;
import com.cat.ceftriaxone.pi.PI_fragment;
import com.cat.ceftriaxone.populations.Populations_fragment;
import com.cat.ceftriaxone.products.Products_fragment;
import com.cat.ceftriaxone.speciality.Speciality_fragment;
import com.cat.ceftriaxone.tips.Tips_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.location.aravind.getlocation.GeoLocator;
import com.steelkiwi.library.view.BadgeHolderLayout;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    int isHome = 1;

    public void setHome(int home) {
        isHome = home;
    }


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

    BadgeHolderLayout notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = findViewById(R.id.notification);
        bottomNavigationView = findViewById(R.id.btm_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        notification.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, NotificationsActivity.class);
            startActivity(i);
        });

        setContentFragment(new Speciality_fragment(), "");

//        getNotificationsCount();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.bottom_nav_bar_speciality) {
            navigateToSpeciality();
        } else if (id == R.id.bottom_nav_bar_indications) {
            navigateToIndications();
        } else if (id == R.id.bottom_nav_bar_products) {
            navigateToProducts();
        } else if (id == R.id.bottom_nav_bar_more) {
            navigateToMore();
        } else if (id == R.id.nav_population) {
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
        if (isHome == 1) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Are you sure you want to exit ? ")
//                    .setMessage("You have to login first")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // Continue with delete operation
                        finish();
                    })
                    .setNegativeButton("Dismiss", null)
                    .show();
        } else if (isHome == 2) {
            super.onBackPressed();
        } else {
            navigateToSpeciality();
        }
    }

    private void getNotificationsCount() {

        Webservice.getInstance().getApi().getCurrentNotificationsCount().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {

                try {
                    assert response.body() != null;
                    JSONObject responseObject = new JSONObject(response.body().string());
                    JSONObject notificationsCountObj = responseObject.getJSONObject("data");
                    int notificationsCount = notificationsCountObj.getInt("count");
                    setNotificationsCount(notificationsCount);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.d("Error Throw", t.toString());
                Log.d("commit Test Throw", t.toString());
                Log.d("Call", t.toString());
                Toast.makeText(getBaseContext(), "Network Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setNotificationsCount(int currentNotificationsCount) {
        int missedNotifications = currentNotificationsCount - NotificationsCount.getNotificationCount(getBaseContext());
        notification.setCountWithAnimation(missedNotifications);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        getNotificationsCount();
    }
}