package com.cat.ceftriaxone.speciality;

import androidx.fragment.app.Fragment;

import com.cat.ceftriaxone.speciality.indications.Indication_02_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_04_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_05_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_06_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_07_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_08_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_09_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_10_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_10_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_11_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_11_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_12_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_12_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_13_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_13_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_14_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_15_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_01_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_01_ped;
import com.cat.ceftriaxone.speciality.indications.Indication_02_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_03_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_04_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_05_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_06_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_07_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_08_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_09_adult;
import com.cat.ceftriaxone.speciality.indications.Indication_15_ped;

import java.util.HashMap;
import java.util.Map;

public class Indications_fragment_names {
    private final Map<Integer, Fragment> fragmentsNames_adult = new HashMap<Integer, Fragment>();
    private final Map<Integer, Fragment> fragmentsNames_ped = new HashMap<Integer, Fragment>();

    public Indications_fragment_names() {
        setFragmentsNames_adult();
        setFragmentsNames_ped();

    }

    private void setFragmentsNames_adult(){
        fragmentsNames_adult.put(1, new Indication_01_adult());
        fragmentsNames_adult.put(2, new Indication_02_adult());
        fragmentsNames_adult.put(3, new Indication_03_adult());
        fragmentsNames_adult.put(4, new Indication_04_adult());
        fragmentsNames_adult.put(5, new Indication_05_adult());
        fragmentsNames_adult.put(6, new Indication_06_adult());
        fragmentsNames_adult.put(7, new Indication_07_adult());
        fragmentsNames_adult.put(8, new Indication_08_adult());
        fragmentsNames_adult.put(9, new Indication_09_adult());
        fragmentsNames_adult.put(10, new Indication_10_adult());
        fragmentsNames_adult.put(11, new Indication_11_adult());
        fragmentsNames_adult.put(12, new Indication_12_adult());
        fragmentsNames_adult.put(13, new Indication_13_adult());
        fragmentsNames_adult.put(14, new Indication_14_adult());
        fragmentsNames_adult.put(15, new Indication_15_adult());
    }


    private void setFragmentsNames_ped(){
        fragmentsNames_ped.put(1, new Indication_01_ped());
        fragmentsNames_ped.put(2, new Indication_02_ped());
        fragmentsNames_ped.put(3, new Indication_03_adult());
        fragmentsNames_ped.put(4, new Indication_04_ped());
        fragmentsNames_ped.put(5, new Indication_05_ped());
        fragmentsNames_ped.put(6, new Indication_06_ped());
        fragmentsNames_ped.put(7, new Indication_07_ped());
        fragmentsNames_ped.put(8, new Indication_08_ped());
        fragmentsNames_ped.put(9, new Indication_09_ped());
        fragmentsNames_ped.put(10, new Indication_10_ped());
        fragmentsNames_ped.put(11, new Indication_11_ped());
        fragmentsNames_ped.put(12, new Indication_12_ped());
        fragmentsNames_ped.put(13, new Indication_13_ped());
        fragmentsNames_ped.put(14, new Indication_14_adult());
        fragmentsNames_ped.put(15, new Indication_15_ped());
    }

    public Map<Integer, Fragment> getFragmentsNames_adult() {
        return fragmentsNames_adult;
    }



    public Map<Integer, Fragment> getFragmentsNames_ped() {
        return fragmentsNames_ped;
    }


}
