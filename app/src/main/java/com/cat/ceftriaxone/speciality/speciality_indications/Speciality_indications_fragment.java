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

import com.cat.ceftriaxone.MainActivity;
import com.cat.ceftriaxone.R;
import com.cat.ceftriaxone.speciality.Indications_names;

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

        MainActivity activity = (MainActivity) getActivity();
        activity.setHome(2);

        items = new ArrayList<>();
        setIndicationsItems();

        indicationsRecycler = view.findViewById(R.id.speciality_indications_recycler);
        setIndicationsRecycler();
    }

    private void setIndicationsItems() {

        Indications_names names = new Indications_names();
        Map<Integer, String> indicationsNames = names.getNames();



        switch (specialityId){
            case 1:
                items.add(new Indications_item(1, R.drawable.ic_chest_indications, indicationsNames.get(1),false));
                items.add(new Indications_item(2, R.drawable.ic_chest_indications,  indicationsNames.get(2),false));
                items.add(new Indications_item(3, R.drawable.ic_chest_indications,  indicationsNames.get(3),false));
                break;

            case 2:
                items.add(new Indications_item(4, R.drawable.ic_ent_indications,  indicationsNames.get(4),false));
                break;

            case 3:
                items.add(new Indications_item(5, R.drawable.ic_surgeon_indications,  indicationsNames.get(5),false));
                items.add(new Indications_item(6, R.drawable.ic_surgeon_indications,  indicationsNames.get(6),false));
                break;

            case 4:
                items.add(new Indications_item(1, R.drawable.ic_im_gp_indications,  indicationsNames.get(1),false));
                items.add(new Indications_item(3, R.drawable.ic_im_gp_indications,  indicationsNames.get(3),false));
                items.add(new Indications_item(4, R.drawable.ic_im_gp_indications,  indicationsNames.get(4),false));
                items.add(new Indications_item(7, R.drawable.ic_im_gp_indications,  indicationsNames.get(7),false));
                items.add(new Indications_item(5, R.drawable.ic_im_gp_indications,  indicationsNames.get(5),false));
                items.add(new Indications_item(8, R.drawable.ic_im_gp_indications,  indicationsNames.get(8),false));
                items.add(new Indications_item(9, R.drawable.ic_im_gp_indications,  indicationsNames.get(9),false));
                items.add(new Indications_item(10, R.drawable.ic_im_gp_indications,  indicationsNames.get(10),false));
                items.add(new Indications_item(11, R.drawable.ic_im_gp_indications,  indicationsNames.get(11),false));
                items.add(new Indications_item(12, R.drawable.ic_im_gp_indications,  indicationsNames.get(12),false));
                break;

            case 5:
                items.add(new Indications_item(13, R.drawable.ic_urology_indications,  indicationsNames.get(13),false));
                items.add(new Indications_item(14, R.drawable.ic_urology_indications,  indicationsNames.get(14),false));
                items.add(new Indications_item(15, R.drawable.ic_urology_indications,  indicationsNames.get(15),false));
                break;

            case 6:
                items.add(new Indications_item(1, R.drawable.ic_pediatric_indications,  indicationsNames.get(1),true));
                items.add(new Indications_item(2, R.drawable.ic_pediatric_indications,  indicationsNames.get(2),true));
                items.add(new Indications_item(4, R.drawable.ic_pediatric_indications,  indicationsNames.get(4),true));
                items.add(new Indications_item(5, R.drawable.ic_pediatric_indications,  indicationsNames.get(5),true));
                items.add(new Indications_item(6, R.drawable.ic_pediatric_indications,  indicationsNames.get(6),true));
                items.add(new Indications_item(12, R.drawable.ic_pediatric_indications,  indicationsNames.get(12),true));
                items.add(new Indications_item(7, R.drawable.ic_pediatric_indications,  indicationsNames.get(7),true));
                items.add(new Indications_item(8, R.drawable.ic_pediatric_indications,  indicationsNames.get(8),true));
                items.add(new Indications_item(9, R.drawable.ic_pediatric_indications,  indicationsNames.get(9),true));
                items.add(new Indications_item(10, R.drawable.ic_pediatric_indications,  indicationsNames.get(10),true));
                items.add(new Indications_item(11, R.drawable.ic_pediatric_indications,  indicationsNames.get(11),true));
                items.add(new Indications_item(13, R.drawable.ic_pediatric_indications,  indicationsNames.get(13),true));
                items.add(new Indications_item(15, R.drawable.ic_pediatric_indications,  indicationsNames.get(15),true));
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