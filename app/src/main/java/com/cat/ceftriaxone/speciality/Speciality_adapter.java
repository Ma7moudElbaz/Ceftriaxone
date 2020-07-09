package com.cat.ceftriaxone.speciality;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cat.ceftriaxone.MainActivity;
import com.cat.ceftriaxone.R;
import com.cat.ceftriaxone.speciality.speciality_indications.Speciality_indications_fragment;

import java.util.ArrayList;
import java.util.List;


public class Speciality_adapter extends RecyclerView.Adapter<Speciality_adapter.ViewHolder> {

    private List<Speciality_item> items;

    private Context mContext;

    public Speciality_adapter(Context context, ArrayList<Speciality_item> items) {

        this.mContext = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Speciality_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciality, parent, false);
        Speciality_adapter.ViewHolder holder = new Speciality_adapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Speciality_adapter.ViewHolder holder, final int position) {


        holder.title.setText(items.get(position).getTitle());
        holder.img.setImageResource(items.get(position).getImg());
        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) mContext;
                activity.setContentFragment(new Speciality_indications_fragment(items.get(position).getId()),"Speciality_indications_fragment");
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;
        LinearLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.speciality_img);
            title = itemView.findViewById(R.id.speciality_title);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}