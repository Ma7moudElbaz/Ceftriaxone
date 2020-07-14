package com.cat.ceftriaxone.speciality.indications;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cat.ceftriaxone.MainActivity;
import com.cat.ceftriaxone.R;
import com.cat.ceftriaxone.speciality.Indications_fragment_names;

import java.util.HashMap;
import java.util.Map;


public class Indication_container extends Fragment {


    private void setContentFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.indication_container, fragment);
        fragmentTransaction.commit();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indication_container, container, false);
    }


    RelativeLayout adult_tab,ped_tab;
     Map<Integer, Fragment> fragmentsNames_adult,fragmentsNames_ped;

    int indicationId;
    boolean isPed;

    public Indication_container(int indicationId , boolean isPed) {
        this.indicationId = indicationId;
        this.isPed = isPed;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.setSpecialityColors();
        activity.setHome(false);


        adult_tab = view.findViewById(R.id.adults_tab);
        ped_tab = view.findViewById(R.id.ped_tab);

        Indications_fragment_names fragment_names = new Indications_fragment_names();
        fragmentsNames_adult = fragment_names.getFragmentsNames_adult();
        fragmentsNames_ped =fragment_names.getFragmentsNames_ped();


        setTabs();
        if (isPed){
            gotoPed();
        }else {
            gotoAdult();
        }

        adult_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAdult();
            }
        });

        ped_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoPed();
            }
        });

    }

    private void setTabs(){
        if (indicationId == 3 || indicationId == 14){
            ped_tab.setVisibility(View.GONE);
        }

    }

    private void gotoAdult(){
        setContentFragment(fragmentsNames_adult.get(indicationId));
        adult_tab.setBackgroundResource(R.drawable.active_tab_bg);
        ped_tab.setBackgroundResource(R.drawable.inactive_tab_bg);
    }

    private void gotoPed(){
        setContentFragment(fragmentsNames_ped.get(indicationId));
        adult_tab.setBackgroundResource(R.drawable.inactive_tab_bg);
        ped_tab.setBackgroundResource(R.drawable.active_tab_bg);
    }
}