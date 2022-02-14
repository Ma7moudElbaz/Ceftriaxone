package com.cat.ceftriaxone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

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
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.steelkiwi.library.view.BadgeHolderLayout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    String device_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        device_id = "Android-"+Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
//        getLocationDataEnglish();


        if (!DeviceUtils.isDeviceInitiated(getBaseContext())) {
            addDeviceLocation(device_id, "", "");
        }
        if (!DeviceUtils.isLocationGranted(getBaseContext())) {

            if (checkPermissions()) {
                if (isLocationEnabled()) {
                    getLocationData();
                }
            } else {
                Log.e("test", "location disabled");
                Dexter.withContext(getBaseContext()).withPermissions(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION).withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        if (multiplePermissionsReport.areAllPermissionsGranted()) {
                            if (isLocationEnabled()) {
                                getLocationData();
                            }
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {

                    }
                }).check();
            }

        }


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

    private void addDeviceLocation(String device_id, String country, String city) {
        Map<String, String> map = new HashMap<>();
        map.put("mac_address", device_id);
        map.put("country", country);
        map.put("city", city);

        Webservice.getInstance().getApi().addDeviceLocation(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (country.equals("")) {
                    DeviceUtils.setDeviceInitiated(getBaseContext(), true);
                } else {
                    DeviceUtils.setDeviceInitiated(getBaseContext(), true);
                    DeviceUtils.setLocationGranted(getBaseContext(), true);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
            }
        });
    }

    //check permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    // check location
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    //get city and country
    private void getLocationData() {
        Locator geoLocator = new Locator(getApplicationContext(), MainActivity.this);
        String cityTxt = "";
        String countryTxt = "";
        try {
            cityTxt = geoLocator.getState();
            countryTxt = geoLocator.getCountry();
        } catch (Exception e) {
            Log.e("Exception", "" + e);
        }
        addDeviceLocation(device_id, countryTxt, cityTxt);

    }

    //get city and country in english
    private void getLocationDataEnglish() {
        Locator geoLocator = new Locator(getApplicationContext(), MainActivity.this);
        try {
//            Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
//            List<Address> addresses = geocoder.getFromLocation(geoLocator.getLattitude(), geoLocator.getLattitude(), 1);
//            String cityName = addresses.get(0).getLocality();
//            String stateName = addresses.get(0).getAdminArea();
//            String countryName = addresses.get(0).getCountryName();

            String cityNameLocate = geoLocator.getCity();
            String stateNameLocate = geoLocator.getState();
            String countryNameLocate = geoLocator.getCountry();

//            Log.e("Data", ""+cityName +"\n" +stateName+"\n" +countryName );
            Log.e("Data Locate", ""+cityNameLocate+"\n" +stateNameLocate +"\n" +countryNameLocate );
        } catch (Exception e) {
            Log.e("Exception", "" + e);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
//        getNotificationsCount();
    }

}