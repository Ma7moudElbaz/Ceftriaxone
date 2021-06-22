package com.cat.ceftriaxone.speciality.speciality_indications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cat.ceftriaxone.MainActivity;
import com.cat.ceftriaxone.R;
import com.cat.ceftriaxone.speciality.indications.Indication_container;

import java.util.ArrayList;
import java.util.List;


public class Indications_adapter extends RecyclerView.Adapter<Indications_adapter.ViewHolder> {

    private final List<Indications_item> items;

    private final Context mContext;

    public Indications_adapter(Context context, ArrayList<Indications_item> items) {

        this.mContext = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Indications_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_indications, parent, false);
        Indications_adapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Indications_adapter.ViewHolder holder, final int position) {


        holder.title.setText(items.get(position).getTitle());
        holder.img.setImageResource(items.get(position).getImg());
        holder.parent_layout.setOnClickListener(view -> {
            MainActivity activity = (MainActivity) mContext;
            activity.setContentFragment(new Indication_container(items.get(position).getId(),items.get(position).isPed),"Indication Container");

        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;
        LinearLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.indications_img);
            title = itemView.findViewById(R.id.indications_title);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}