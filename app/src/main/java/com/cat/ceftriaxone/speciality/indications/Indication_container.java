package com.cat.ceftriaxone.speciality.indications;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cat.ceftriaxone.MainActivity;
import com.cat.ceftriaxone.R;
import com.cat.ceftriaxone.network.Webservice;
import com.cat.ceftriaxone.speciality.Indications_fragment_names;
import com.cat.ceftriaxone.speciality.Indications_names;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

    LinearLayout tabs_container;
    RelativeLayout adult_tab, ped_tab;
    TextView adult_text, ped_text;
    Map<Integer, Fragment> fragmentsNames_adult, fragmentsNames_ped;


    int indicationId;
    boolean isPed;

    public Indication_container(int indicationId, boolean isPed) {
        this.indicationId = indicationId;
        this.isPed = isPed;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.setHome(2);


        tabs_container = view.findViewById(R.id.tabs_container);
        adult_tab = view.findViewById(R.id.adults_tab);
        ped_tab = view.findViewById(R.id.ped_tab);
        adult_text = view.findViewById(R.id.adults_text);
        ped_text = view.findViewById(R.id.ped_text);

        Indications_fragment_names fragment_names = new Indications_fragment_names();
        fragmentsNames_adult = fragment_names.getFragmentsNames_adult();
        fragmentsNames_ped = fragment_names.getFragmentsNames_ped();


        setTabs();
        if (isPed) {
            gotoPed();
        } else {
            gotoAdult();
        }

        adult_tab.setOnClickListener(v -> gotoAdult());

        ped_tab.setOnClickListener(v -> gotoPed());

        addIndicationToDeviceActivity();

    }

    private void setTabs() {
        //to remove ped tab
//        ped_tab.setVisibility(View.GONE);

        //normal app ped tab in all except 3 &14
        if (indicationId == 3 || indicationId == 14) {
            ped_tab.setVisibility(View.GONE);
            tabs_container.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white_blue, null));

        }

    }

    @SuppressLint("ResourceAsColor")
    private void gotoAdult() {
        setContentFragment(fragmentsNames_adult.get(indicationId));
        adult_tab.setBackgroundResource(R.drawable.active_tab_bg);
        adult_text.setTextColor(
                ResourcesCompat.getColor(getResources(), R.color.white, null));
        adult_text.setTypeface(null, Typeface.BOLD);
        ped_tab.setBackgroundResource(R.drawable.inactive_tab_bg);
        ped_text.setTextColor(
                ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
        ped_text.setTypeface(null, Typeface.NORMAL);
    }

    private void gotoPed() {
        setContentFragment(fragmentsNames_ped.get(indicationId));
        adult_tab.setBackgroundResource(R.drawable.inactive_tab_bg);
        adult_text.setTextColor(
                ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
        adult_text.setTypeface(null, Typeface.NORMAL);
        ped_tab.setBackgroundResource(R.drawable.active_tab_bg);
        ped_text.setTextColor(
                ResourcesCompat.getColor(getResources(), R.color.white, null));
        ped_text.setTypeface(null, Typeface.BOLD);
    }

    private void addIndicationToDeviceActivity() {
        Indications_names names = new Indications_names();
        Map<Integer, String> indicationsNames = names.getNames();
        String selectedIndicationName = indicationsNames.get(indicationId);
        String device_id = "Android-"+Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID);
        Map<String, String> map = new HashMap<>();
        map.put("mac_address", device_id);
        map.put("screen", selectedIndicationName.toLowerCase(Locale.ROOT));

        Webservice.getInstance().getApi().addDeviceActivity(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
            }
        });
    }

}