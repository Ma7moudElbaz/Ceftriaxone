package com.cat.ceftriaxone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

import com.anirudh.locationfetch.EasyLocationFetch;
import com.anirudh.locationfetch.GeoLocationModel;
import com.cat.ceftriaxone.network.Webservice;
import com.cat.ceftriaxone.speciality.Indications_names;
import com.location.aravind.getlocation.GeoLocator;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    TextView tvCity, tvCountry, tvMac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }
        tvCity = findViewById(R.id.tvCity);
        tvCountry = findViewById(R.id.tvCountry);
        tvMac = findViewById(R.id.mac);
        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        tvMac.setText(device_id);









        GeoLocator geoLocator = new GeoLocator(getApplicationContext(), this);
        try {
            tvCity.setText(geoLocator.getCity());
            tvCountry.setText(geoLocator.getCountry());
        } catch (Exception e) {
            Log.e("Exception", "" + e);
        }

        addDeviceLocation(device_id,geoLocator.getCity(),geoLocator.getCountry());

//        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        locationEnabled();
//        getLocation();
        navigateMainTimer();
    }

    private void locationEnabled() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(SplashActivity.this)
                    .setTitle("Enable GPS Service")
                    .setMessage("We need your GPS location to show Near Places around you.")
                    .setCancelable(false)
                    .setPositiveButton("Enable", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                }
                            })
                    .setNegativeButton("Cancel", null)
                    .show();
        }
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, (LocationListener) this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        try {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            tvCity.setText(addresses.get(0).getLocality());
            tvCountry.setText(addresses.get(0).getCountryName());

        } catch (Exception e) {
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    private void navigateMainTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }


    private void addDeviceLocation(String device_id, String country, String city) {
        Map<String, String> map = new HashMap<>();
        map.put("mac_address", device_id);
        map.put("country", country);
        map.put("city", city);

        Webservice.getInstance().getApi().addDeviceLocation(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
            }
        });
    }
}