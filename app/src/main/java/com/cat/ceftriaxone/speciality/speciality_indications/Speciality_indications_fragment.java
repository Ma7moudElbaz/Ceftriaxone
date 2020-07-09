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
import com.cat.ceftriaxone.speciality.Indications_fragment_names;
import com.cat.ceftriaxone.speciality.Indications_names;
import com.cat.ceftriaxone.speciality.indications.Indication_2;
import com.cat.ceftriaxone.speciality.indications.Indication_3;
import com.cat.ceftriaxone.speciality.indications.Indication_4;

import java.util.ArrayList;
import java.util.Map;

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

        Indications_names names = new Indications_names();
        Map<Integer, String> indicationsNames = names.getNames();

        Indications_fragment_names fnames = new Indications_fragment_names();
        Map<Integer, Fragment> fragmentsNames = fnames.getFragmentsNames();


        switch (specialityId){
            case 1:
                items.add(new Indications_item(1, R.drawable.ic_chest, indicationsNames.get(1),fragmentsNames.get(1)));
                items.add(new Indications_item(2, R.drawable.ic_chest,  indicationsNames.get(2),fragmentsNames.get(2)));
                items.add(new Indications_item(3, R.drawable.ic_chest,  indicationsNames.get(3),fragmentsNames.get(3)));
                break;

            case 2:
                items.add(new Indications_item(4, R.drawable.ic_ent,  indicationsNames.get(4),fragmentsNames.get(4)));
                break;

            case 3:
                items.add(new Indications_item(5, R.drawable.ic_surgeon,  indicationsNames.get(5),fragmentsNames.get(5)));
                items.add(new Indications_item(6, R.drawable.ic_surgeon,  indicationsNames.get(6),fragmentsNames.get(6)));
                break;

            case 4:
                items.add(new Indications_item(1, R.drawable.ic_im_gp,  indicationsNames.get(1),fragmentsNames.get(1)));
                items.add(new Indications_item(3, R.drawable.ic_im_gp,  indicationsNames.get(3),fragmentsNames.get(3)));
                items.add(new Indications_item(4, R.drawable.ic_im_gp,  indicationsNames.get(4),fragmentsNames.get(4)));
                items.add(new Indications_item(7, R.drawable.ic_im_gp,  indicationsNames.get(7),fragmentsNames.get(7)));
                items.add(new Indications_item(5, R.drawable.ic_im_gp,  indicationsNames.get(5),fragmentsNames.get(5)));
                items.add(new Indications_item(8, R.drawable.ic_im_gp,  indicationsNames.get(8),fragmentsNames.get(8)));
                items.add(new Indications_item(9, R.drawable.ic_im_gp,  indicationsNames.get(9),fragmentsNames.get(9)));
                items.add(new Indications_item(10, R.drawable.ic_im_gp,  indicationsNames.get(10),fragmentsNames.get(10)));
                items.add(new Indications_item(11, R.drawable.ic_im_gp,  indicationsNames.get(11),fragmentsNames.get(11)));
                items.add(new Indications_item(12, R.drawable.ic_im_gp,  indicationsNames.get(12),fragmentsNames.get(12)));
                break;

            case 5:
                items.add(new Indications_item(13, R.drawable.ic_urology,  indicationsNames.get(13),fragmentsNames.get(13)));
                items.add(new Indications_item(14, R.drawable.ic_urology,  indicationsNames.get(14),fragmentsNames.get(14)));
                items.add(new Indications_item(15, R.drawable.ic_urology,  indicationsNames.get(15),fragmentsNames.get(15)));
                break;

            case 6:
                items.add(new Indications_item(1, R.drawable.ic_pediatric,  indicationsNames.get(1),fragmentsNames.get(1)));
                items.add(new Indications_item(2, R.drawable.ic_pediatric,  indicationsNames.get(2),fragmentsNames.get(2)));
                items.add(new Indications_item(4, R.drawable.ic_pediatric,  indicationsNames.get(4),fragmentsNames.get(4)));
                items.add(new Indications_item(5, R.drawable.ic_pediatric,  indicationsNames.get(5),fragmentsNames.get(5)));
                items.add(new Indications_item(6, R.drawable.ic_pediatric,  indicationsNames.get(6),fragmentsNames.get(6)));
                items.add(new Indications_item(12, R.drawable.ic_pediatric,  indicationsNames.get(12),fragmentsNames.get(12)));
                items.add(new Indications_item(7, R.drawable.ic_pediatric,  indicationsNames.get(7),fragmentsNames.get(7)));
                items.add(new Indications_item(8, R.drawable.ic_pediatric,  indicationsNames.get(8),fragmentsNames.get(8)));
                items.add(new Indications_item(9, R.drawable.ic_pediatric,  indicationsNames.get(9),fragmentsNames.get(9)));
                items.add(new Indications_item(10, R.drawable.ic_pediatric,  indicationsNames.get(10),fragmentsNames.get(10)));
                items.add(new Indications_item(11, R.drawable.ic_pediatric,  indicationsNames.get(11),fragmentsNames.get(11)));
                items.add(new Indications_item(13, R.drawable.ic_pediatric,  indicationsNames.get(13),fragmentsNames.get(13)));
                items.add(new Indications_item(15, R.drawable.ic_pediatric,  indicationsNames.get(15),fragmentsNames.get(15)));
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