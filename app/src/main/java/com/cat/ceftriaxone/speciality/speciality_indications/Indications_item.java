package com.cat.ceftriaxone.speciality.speciality_indications;

import androidx.fragment.app.Fragment;

public class Indications_item {
    private int id,img;
    private String title;
    private Fragment fragment;

    public Indications_item(int id, int img, String title, Fragment fragment) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.fragment = fragment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
