package com.cat.ceftriaxone.speciality.indications;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.cat.ceftriaxone.DetailsDialog;
import com.cat.ceftriaxone.R;


public class Indication_15_ped extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indication_15_ped, container, false);
    }

    ImageView next, prev,info;
    ScrollView slide1, slide2;
    EditText dosage, weight;
    TextView indicationDosage, dose;

    int minDosage, maxDosage;
    String dosageTxt;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        next = view.findViewById(R.id.next);
        prev = view.findViewById(R.id.prev);
        info = view.findViewById(R.id.info);
        slide1 = view.findViewById(R.id.slide_1);
        slide2 = view.findViewById(R.id.slide_2);
        indicationDosage = view.findViewById(R.id.indication_dosage);
        dosage = view.findViewById(R.id.et_dosage);
        weight = view.findViewById(R.id.et_weight);
        dose = view.findViewById(R.id.dose);

        minDosage = 75;
        maxDosage = 100;
        dosageTxt = minDosage + "-" + maxDosage;
        indicationDosage.setText(dosageTxt);

        next.setOnClickListener(v -> calculateDose());

        prev.setOnClickListener(v -> {
            slide1.setVisibility(View.VISIBLE);
            slide2.setVisibility(View.GONE);
        });

        info.setOnClickListener(v -> new DetailsDialog("The dose recommendations in syphilis, including neurosyphilis, are based on limited data. National or local guidance should be taken into consideration").
                show(getFragmentManager(), "dialog"));
    }


    private void calculateDose() {
        String currentDosage = dosage.getText().toString();
        String currentWeight = weight.getText().toString();

        if (currentDosage.length() == 0 || currentWeight.length() == 0) {
            Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else if (Integer.parseInt(currentDosage) < minDosage || Integer.parseInt(currentDosage) > maxDosage) {
            Toast.makeText(getActivity(), "Dosage should Be "+dosageTxt, Toast.LENGTH_SHORT).show();

        } else {
            int totalDose = Integer.parseInt(currentDosage) * Integer.parseInt(currentWeight);
            dose.setText(String.valueOf(totalDose));
            slide1.setVisibility(View.GONE);
            slide2.setVisibility(View.VISIBLE);
        }
    }
}