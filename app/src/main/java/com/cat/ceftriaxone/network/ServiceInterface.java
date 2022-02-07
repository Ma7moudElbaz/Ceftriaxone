package com.cat.ceftriaxone.network;


import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ServiceInterface {

    @POST("devices")
    @FormUrlEncoded
    Call<ResponseBody> addDeviceLocation(@FieldMap Map<String, String> map);

    @POST("activities")
    @FormUrlEncoded
    Call<ResponseBody> addDeviceActivity(@FieldMap Map<String, String> map);

    @GET("notification")
    Call<ResponseBody> getNotifications();

    @GET("notification/count")
    Call<ResponseBody> getCurrentNotificationsCount();

}