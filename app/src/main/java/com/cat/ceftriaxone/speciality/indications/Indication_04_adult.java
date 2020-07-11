package com.cat.ceftriaxone.speciality.indications;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cat.ceftriaxone.R;

public class Indication_04_adult extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indication_04_adult, container, false);
    }

    ImageView info;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         info = view.findViewById(R.id.info);
         info.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 new AlertDialog.Builder(getActivity())
                    .setMessage("Limited data suggest that If the patient is severely ill or the previous therapy has failed, Ceftriaxone may be effective when given for 3 days.")

                    .show();
             }
         });
    }
}