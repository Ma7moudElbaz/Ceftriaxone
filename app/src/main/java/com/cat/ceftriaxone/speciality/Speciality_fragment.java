package com.cat.ceftriaxone.speciality;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.ceftriaxone.R;

import java.util.ArrayList;


public class Speciality_fragment extends Fragment {


    RecyclerView specialityRecycler;
    ArrayList<Speciality_item> items;
    Speciality_adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.speciality_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        items = new ArrayList<>();
        items.add(new Speciality_item(1,R.drawable.ic_chest,"Chest"));
        items.add(new Speciality_item(1,R.drawable.ic_ent,"Ear, Nose and Throat(ENT)"));
        items.add(new Speciality_item(1,R.drawable.ic_surgeon,"Surgeon"));
        items.add(new Speciality_item(1,R.drawable.ic_im_gp,"Internal Medicine (IM) General Practitioner (GP)"));
        items.add(new Speciality_item(1,R.drawable.ic_urology,"Urology"));
        items.add(new Speciality_item(1,R.drawable.ic_pediatric,"Pediatrics"));

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        specialityRecycler = view.findViewById(R.id.speciality_recycler);
         adapter = new Speciality_adapter(getActivity(), items);
        specialityRecycler.setLayoutManager(layoutManager);
        specialityRecycler.setAdapter(adapter);
    }
}