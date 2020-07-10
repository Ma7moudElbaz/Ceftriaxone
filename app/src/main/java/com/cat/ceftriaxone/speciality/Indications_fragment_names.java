package com.cat.ceftriaxone.speciality;

import androidx.fragment.app.Fragment;

import com.cat.ceftriaxone.speciality.indications.Indication_10;
import com.cat.ceftriaxone.speciality.indications.Indication_11;
import com.cat.ceftriaxone.speciality.indications.Indication_12;
import com.cat.ceftriaxone.speciality.indications.Indication_13;
import com.cat.ceftriaxone.speciality.indications.Indication_14;
import com.cat.ceftriaxone.speciality.indications.Indication_15;
import com.cat.ceftriaxone.speciality.indications.Indication_1_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_1_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_2_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_3_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_4_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_5;
import com.cat.ceftriaxone.speciality.indications.Indication_6;
import com.cat.ceftriaxone.speciality.indications.Indication_7;
import com.cat.ceftriaxone.speciality.indications.Indication_8;
import com.cat.ceftriaxone.speciality.indications.Indication_9;

import java.util.HashMap;
import java.util.Map;

public class Indications_fragment_names {
    private Map<Integer, Fragment> fragmentsNames_adult = new HashMap<Integer, Fragment>();
    private Map<Integer, Fragment> fragmentsNames_ped = new HashMap<Integer, Fragment>();

    public Indications_fragment_names() {
        setFragmentsNames_adult();
        setFragmentsNames_ped();

    }

    private void setFragmentsNames_adult(){
        fragmentsNames_adult.put(1, new Indication_1_adult());
        fragmentsNames_adult.put(2, new Indication_2_adult());
        fragmentsNames_adult.put(3, new Indication_3_adult());
        fragmentsNames_adult.put(4, new Indication_4_adult());
        fragmentsNames_adult.put(5, new Indication_5());
        fragmentsNames_adult.put(6, new Indication_6());
        fragmentsNames_adult.put(7, new Indication_7());
        fragmentsNames_adult.put(8, new Indication_8());
        fragmentsNames_adult.put(9, new Indication_9());
        fragmentsNames_adult.put(10, new Indication_10());
        fragmentsNames_adult.put(11, new Indication_11());
        fragmentsNames_adult.put(12, new Indication_12());
        fragmentsNames_adult.put(13, new Indication_13());
        fragmentsNames_adult.put(14, new Indication_14());
        fragmentsNames_adult.put(15, new Indication_15());
    }


    private void setFragmentsNames_ped(){
        fragmentsNames_ped.put(1, new Indication_1_ped());
        fragmentsNames_ped.put(2, new Indication_2_adult());
        fragmentsNames_ped.put(3, new Indication_3_adult());
        fragmentsNames_ped.put(4, new Indication_4_adult());
        fragmentsNames_ped.put(5, new Indication_5());
        fragmentsNames_ped.put(6, new Indication_6());
        fragmentsNames_ped.put(7, new Indication_7());
        fragmentsNames_ped.put(8, new Indication_8());
        fragmentsNames_ped.put(9, new Indication_9());
        fragmentsNames_ped.put(10, new Indication_10());
        fragmentsNames_ped.put(11, new Indication_11());
        fragmentsNames_ped.put(12, new Indication_12());
        fragmentsNames_ped.put(13, new Indication_13());
        fragmentsNames_ped.put(14, new Indication_14());
        fragmentsNames_ped.put(15, new Indication_15());
    }

    public Map<Integer, Fragment> getFragmentsNames_adult() {
        return fragmentsNames_adult;
    }

    public void setFragmentsNames_adult(Map<Integer, Fragment> fragmentsNames_adult) {
        this.fragmentsNames_adult = fragmentsNames_adult;
    }

    public Map<Integer, Fragment> getFragmentsNames_ped() {
        return fragmentsNames_ped;
    }

    public void setFragmentsNames_ped(Map<Integer, Fragment> fragmentsNames_ped) {
        this.fragmentsNames_ped = fragmentsNames_ped;
    }
}
