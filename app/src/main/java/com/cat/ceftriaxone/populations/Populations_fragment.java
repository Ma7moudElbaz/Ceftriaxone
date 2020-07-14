package com.cat.ceftriaxone.populations;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.cat.ceftriaxone.MainActivity;
import com.cat.ceftriaxone.R;


public class Populations_fragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.populations_fragment, container, false);
    }

    WebView webView;
    ImageView population1, population2, population3, population4;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity activity = (MainActivity) getActivity();
        activity.setPopulationsColors();

        webView = view.findViewById(R.id.webView);
        population1 = view.findViewById(R.id.population_1);
        population2 = view.findViewById(R.id.population_2);
        population3 = view.findViewById(R.id.population_3);
        population4 = view.findViewById(R.id.population_4);

        WebSettings webSetting = webView.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setDisplayZoomControls(false);
        webSetting.setLoadWithOverviewMode(true);
//        webSetting.setUseWideViewPort(true);

        population1.setOnClickListener(this);
        population2.setOnClickListener(this);
        population3.setOnClickListener(this);
        population4.setOnClickListener(this);

        goToPopulation1();



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.population_1:
                goToPopulation1();
                break;
            case R.id.population_2:
                goToPopulation2();
                break;
            case R.id.population_3:
                goToPopulation3();
                break;
            case R.id.population_4:
                goToPopulation4();
                break;

        }
    }

    private void goToPopulation1(){
        webView.loadUrl("file:///android_asset/html/populations_1.html");
        population1.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.active_population_tab));
        population2.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population3.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population4.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
    }

    private void goToPopulation2(){
        webView.loadUrl("file:///android_asset/html/populations_2.html");
        population1.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population2.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.active_population_tab));
        population3.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population4.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
    }

    private void goToPopulation3(){
        webView.loadUrl("file:///android_asset/html/populations_3.html");
        population1.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population2.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population3.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.active_population_tab));
        population4.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
    }

    private void goToPopulation4(){
        webView.loadUrl("file:///android_asset/html/populations_4.html");
        population1.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population2.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population3.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_population_tab));
        population4.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.active_population_tab));
    }
}