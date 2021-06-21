package com.cat.ceftriaxone.notifications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cat.ceftriaxone.NotificationsCount;
import com.cat.ceftriaxone.R;
import com.cat.ceftriaxone.network.Webservice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NotificationsActivity extends AppCompatActivity {

    ImageView back;

    ArrayList<Notifications_item> notifications_list;
    RecyclerView notifications_recycler;
    Notifications_adapter notifications_adapter;

    ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());

        loading = findViewById(R.id.loading);
        notifications_recycler = findViewById(R.id.recycler);

        notifications_list = new ArrayList<>();

        initNotificationsRecyclerView();
        loadNotificationsData();
    }

    public void loadNotificationsData() {
        loading.setVisibility(View.VISIBLE);

        Webservice.getInstance().getApi().getNotifications().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {

                try {
                    assert response.body() != null;
                    JSONObject responseObject = new JSONObject(response.body().string());
                    int currentNotificationsCount = responseObject.getInt("count");
                    JSONArray notificationsArray = responseObject.getJSONArray("data");
                    setNotifications(notificationsArray);
                    NotificationsCount.setNotificationCount(getBaseContext(),currentNotificationsCount);
                    loading.setVisibility(View.GONE);


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
                loading.setVisibility(View.GONE);
            }
        });
    }


    public void setNotifications(JSONArray list) {
        try {
            for (int i = 0; i < list.length(); i++) {
                JSONObject currentObject = list.getJSONObject(i);
                final String title = currentObject.getString("title");
                final String body = currentObject.getString("body");
                final String imageUrl = currentObject.getString("image");
                final String date = currentObject.getString("created_at");

                notifications_list.add(new Notifications_item(title, body, imageUrl, date));

            }
            notifications_adapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void initNotificationsRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        notifications_recycler.setLayoutManager(layoutManager);
        notifications_adapter = new Notifications_adapter(getBaseContext(), notifications_list);
        notifications_recycler.setAdapter(notifications_adapter);


    }
}