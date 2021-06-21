package com.cat.ceftriaxone.network;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceInterface {

    @GET("notification")
    Call<ResponseBody> getNotifications();

    @GET("notification/count")
    Call<ResponseBody> getCurrentNotificationsCount();

}