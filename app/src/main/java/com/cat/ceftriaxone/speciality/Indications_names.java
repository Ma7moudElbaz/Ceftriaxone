package com.cat.ceftriaxone.speciality;

import java.util.HashMap;
import java.util.Map;

public class Indications_names {
    private final Map<Integer, String> names = new HashMap<Integer, String>();

    public Indications_names() {
        names.put(1, "Community acquired pneumonia (CAP)");
        names.put(2, "Hospital acquired pneumonia (HAP))");
        names.put(3, "Acute exacerbations of chronic obstructive pulmonary disease (COPD) in adults");
        names.put(4, "Acute otitis media (AOM)");
        names.put(5, "Complicated skin and soft tissue infections");
        names.put(6, "Pre-operative prophylaxis of surgical site infection");
        names.put(7, "Intra-abdominal infections");
        names.put(8, "Infections of bones and joints");
        names.put(9, "Bacterial Meningitis");
        names.put(10, "Bacterial Endocarditis");
        names.put(11, "Neutropenic patients with fever that is suspected to be due to a bacterial infection");
        names.put(12, "Disseminated Lyme borreliosis");
        names.put(13, "Complicated urinary tract infections (including pyelonephritis)");
        names.put(14, "Gonorrhoea");
        names.put(15, "Syphilis - Neurosyphilis");
    }

    public Map<Integer, String> getNames() {
        return names;
    }
}
