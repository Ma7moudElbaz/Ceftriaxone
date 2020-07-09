package com.cat.ceftriaxone.speciality;

import androidx.fragment.app.Fragment;

import com.cat.ceftriaxone.speciality.indications.Indication_1;
import com.cat.ceftriaxone.speciality.indications.Indication_2;
import com.cat.ceftriaxone.speciality.indications.Indication_3;
import com.cat.ceftriaxone.speciality.indications.Indication_4;
import com.cat.ceftriaxone.speciality.indications.Indication_5;

import java.util.HashMap;
import java.util.Map;

public class Indications_fragment_names {
    private Map<Integer, Fragment> fragmentsNames = new HashMap<Integer, Fragment>();

    public Indications_fragment_names() {
        fragmentsNames.put(1, new Indication_1());
        fragmentsNames.put(2, new Indication_2());
        fragmentsNames.put(3, new Indication_3());
        fragmentsNames.put(4, new Indication_4());
        fragmentsNames.put(5, new Indication_5());
        fragmentsNames.put(6, new Indication_1());
        fragmentsNames.put(7, new Indication_1());
        fragmentsNames.put(8, new Indication_1());
        fragmentsNames.put(9, new Indication_1());
        fragmentsNames.put(10, new Indication_1());
        fragmentsNames.put(11, new Indication_1());
        fragmentsNames.put(12, new Indication_1());
        fragmentsNames.put(13, new Indication_1());
        fragmentsNames.put(14, new Indication_1());
        fragmentsNames.put(15, new Indication_1());
    }

    public Map<Integer, Fragment> getFragmentsNames() {
        return fragmentsNames;
    }
}
