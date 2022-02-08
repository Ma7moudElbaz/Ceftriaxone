package com.cat.ceftriaxone;

import android.content.Context;
import android.content.SharedPreferences;

public class DeviceUtils {

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
    }

    public static void setDeviceInitiated(Context context, boolean isInitiated) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean("isInitiated", isInitiated);
        editor.apply();
    }

    public static boolean isDeviceInitiated(Context context) {
        return getSharedPreferences(context).getBoolean("isInitiated",false);
    }

    public static void setLocationGranted(Context context, boolean isLocationGranted) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean("isLocationGranted", isLocationGranted);
        editor.apply();
    }

    public static boolean isLocationGranted(Context context) {
        return getSharedPreferences(context).getBoolean("isLocationGranted",false);
    }

}
