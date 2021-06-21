package com.cat.ceftriaxone;

import android.content.Context;
import android.content.SharedPreferences;

public class NotificationsCount {


    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
    }

    public static void setNotificationCount(Context context,int notificationsCount) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt("Notifications_count", notificationsCount);
        editor.apply();
    }

    public static int getNotificationCount(Context context) {
        return getSharedPreferences(context).getInt("Notifications_count", 0);
    }
}
