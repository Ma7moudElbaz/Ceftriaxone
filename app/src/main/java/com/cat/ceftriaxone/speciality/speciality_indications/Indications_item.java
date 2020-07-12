package com.cat.ceftriaxone.speciality.speciality_indications;

import androidx.fragment.app.Fragment;

public class Indications_item {
    private int id,img;
    private String title;
    boolean isPed;

    public Indications_item(int id, int img, String title, boolean isPed) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.isPed = isPed;
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

    public boolean isPed() {
        return isPed;
    }

    public void setPed(boolean ped) {
        isPed = ped;
    }
}
