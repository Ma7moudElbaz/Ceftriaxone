package com.cat.ceftriaxone.more;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cat.ceftriaxone.MainActivity;
import com.cat.ceftriaxone.R;
import com.cat.ceftriaxone.contraindications.Contraindications_fragment;
import com.cat.ceftriaxone.pi.PI_fragment;
import com.cat.ceftriaxone.populations.Populations_fragment;
import com.cat.ceftriaxone.speciality.indications.Indication_container;
import com.cat.ceftriaxone.tips.Tips_fragment;

public class More_fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    TextView population, contraindication, tips, pi;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity activity = (MainActivity) getActivity();
        activity.setHome(0);

        population = view.findViewById(R.id.population);
        contraindication = view.findViewById(R.id.contraindication);
        tips = view.findViewById(R.id.tips);
        pi = view.findViewById(R.id.pi);

        population.setOnClickListener(v -> activity.setContentFragment(new Populations_fragment(), "Populations fragment"));
        contraindication.setOnClickListener(v -> activity.setContentFragment(new Contraindications_fragment(), "Contraindications fragment"));
        tips.setOnClickListener(v -> activity.setContentFragment(new Tips_fragment(), "Tips fragment"));
        pi.setOnClickListener(v -> activity.setContentFragment(new PI_fragment(), "PI fragment"));


    }
}