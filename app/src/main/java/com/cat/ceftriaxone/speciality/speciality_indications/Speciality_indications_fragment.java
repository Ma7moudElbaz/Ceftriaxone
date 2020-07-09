package com.cat.ceftriaxone.speciality.speciality_indications;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.ceftriaxone.R;
import com.cat.ceftriaxone.speciality.Speciality_adapter;
import com.cat.ceftriaxone.speciality.Speciality_item;

import java.util.ArrayList;

public class Speciality_indications_fragment extends Fragment {

    RecyclerView indicationsRecycler;
    ArrayList<Indications_item> items;
    Indications_adapter adapter;

    int specialityId;

    public Speciality_indications_fragment(int specialityId) {
        // Required empty public constructor
        this.specialityId = specialityId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.speciality_indications_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        items = new ArrayList<>();
        setIndicationsItems();

        indicationsRecycler = view.findViewById(R.id.speciality_indications_recycler);
        setIndicationsRecycler();
    }

    private void setIndicationsItems() {
        switch (specialityId){
            case 1:
                items.add(new Indications_item(1, R.drawable.ic_chest, "Community acquired pneumonia (CAP)"));
                items.add(new Indications_item(2, R.drawable.ic_chest, "Hospital acquired pneumonia (HAP))"));
                items.add(new Indications_item(3, R.drawable.ic_chest, "Acute exacerbations of chronic obstructive pulmonary disease (COPD) in adults"));
                break;

            case 2:
                items.add(new Indications_item(4, R.drawable.ic_ent, "Acute otitis media (AOM)"));
                break;

            case 3:
                items.add(new Indications_item(5, R.drawable.ic_surgeon, "Complicated skin and soft tissue infections"));
                items.add(new Indications_item(6, R.drawable.ic_surgeon, "Pre-operative prophylaxis of surgical site infection"));
                break;

            case 4:
                items.add(new Indications_item(7, R.drawable.ic_im_gp, "Community acquired pneumonia (CAP)"));
                items.add(new Indications_item(8, R.drawable.ic_im_gp, "Acute exacerbations of chronic obstructive pulmonary disease (COPD) in adults"));
                items.add(new Indications_item(9, R.drawable.ic_im_gp, "Acute otitis media (AOM)"));
                items.add(new Indications_item(10, R.drawable.ic_im_gp, "Intra-abdominal infections"));
                items.add(new Indications_item(11, R.drawable.ic_im_gp, "Complicated skin and soft tissue infections"));
                items.add(new Indications_item(12, R.drawable.ic_im_gp, "Infections of bones and joints"));
                items.add(new Indications_item(13, R.drawable.ic_im_gp, "Bacterial Meningitis"));
                items.add(new Indications_item(14, R.drawable.ic_im_gp, "Bacterial Endocarditis"));
                items.add(new Indications_item(15, R.drawable.ic_im_gp, "Neutropenic patients with fever that is suspected to be due to a bacterial infection"));
                items.add(new Indications_item(16, R.drawable.ic_im_gp, "Disseminated Lyme borreliosis"));
                break;

            case 5:
                items.add(new Indications_item(17, R.drawable.ic_urology, "Complicated urinary tract infections (including pyelonephritis)"));
                items.add(new Indications_item(18, R.drawable.ic_urology, "Gonorrhoea"));
                items.add(new Indications_item(19, R.drawable.ic_urology, "Syphilis - Neurosyphilis"));
                break;

            case 6:
                items.add(new Indications_item(20, R.drawable.ic_pediatric, "Community acquired pneumonia (CAP)"));
                items.add(new Indications_item(21, R.drawable.ic_pediatric, "Hospital acquired pneumonia (HAP)"));
                items.add(new Indications_item(22, R.drawable.ic_pediatric, "Acute otitis media (AOM)"));
                items.add(new Indications_item(23, R.drawable.ic_pediatric, "Complicated skin and soft tissue infections"));
                items.add(new Indications_item(24, R.drawable.ic_pediatric, "Pre-operative prophylaxis for surgical site infection"));
                items.add(new Indications_item(25, R.drawable.ic_pediatric, "Disseminated Lyme borreliosis"));
                items.add(new Indications_item(26, R.drawable.ic_pediatric, "Intra-abdominal infections"));
                items.add(new Indications_item(27, R.drawable.ic_pediatric, "Infections of bones and joints"));
                items.add(new Indications_item(28, R.drawable.ic_pediatric, "Bacterial Meningitis"));
                items.add(new Indications_item(29, R.drawable.ic_pediatric, "Bacterial Endocarditis"));
                items.add(new Indications_item(30, R.drawable.ic_pediatric, "Neutropenic patients with fever that is suspected to be due to a bacterial infection"));
                items.add(new Indications_item(31, R.drawable.ic_pediatric, "Complicated urinary tract infections (including pyelonephritis)"));
                items.add(new Indications_item(32, R.drawable.ic_pediatric, "Syphilis - Neurosyphilis"));
                break;
        }



        }
    private void setIndicationsRecycler(){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        adapter = new Indications_adapter(getActivity(), items);
        indicationsRecycler.setLayoutManager(layoutManager);
        indicationsRecycler.setAdapter(adapter);
    }
}