package com.cat.ceftriaxone.speciality.indications;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cat.ceftriaxone.DetailsDialog;
import com.cat.ceftriaxone.R;

public class Indication_15_adult extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indication_15_adult, container, false);
    }

    ImageView info1,info2;
    LinearLayout next,prev,slide1,slide2;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        info1 = view.findViewById(R.id.info1);
        info2 = view.findViewById(R.id.info2);
        next = view.findViewById(R.id.next);
        prev = view.findViewById(R.id.prev);
        slide1 = view.findViewById(R.id.slide_1);
        slide2 = view.findViewById(R.id.slide_2);

        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DetailsDialog("The dose recommendations are based on limited data. National or local guidance should be taken into consideration").
                        show(getFragmentManager(), "dialog");
            }
        });


        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DetailsDialog("The dose recommendations are based on limited data. National or local guidance should be taken into consideration").
                        show(getFragmentManager(), "dialog");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slide1.setVisibility(View.GONE);
                slide2.setVisibility(View.VISIBLE);
            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slide1.setVisibility(View.VISIBLE);
                slide2.setVisibility(View.GONE);
            }
        });
    }
}