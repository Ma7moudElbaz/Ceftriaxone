package com.cat.ceftriaxone.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cat.ceftriaxone.R;


import java.util.ArrayList;
import java.util.List;


public class Notifications_adapter extends RecyclerView.Adapter<Notifications_adapter.ViewHolder> {

    private final List<Notifications_item> items;

    private final Context mContext;

    public Notifications_adapter(Context context, ArrayList<Notifications_item> items) {
        this.mContext = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.title.setText(items.get(position).getTitle());
        holder.caption.setText(items.get(position).getBody());
        holder.date.setText(String.valueOf(items.get(position).getDate()));

        Glide.with(mContext).load(items.get(position).getImageUrl()).placeholder(R.drawable.image_loading).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView title;
        final TextView date;
        final TextView caption;
        final ImageView image;
        final LinearLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.notification_title);
            caption = itemView.findViewById(R.id.notification_body);
            date = itemView.findViewById(R.id.notification_date);
            image = itemView.findViewById(R.id.notification_img);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}