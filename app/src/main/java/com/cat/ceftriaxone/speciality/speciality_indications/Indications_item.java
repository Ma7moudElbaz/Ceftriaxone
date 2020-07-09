package com.cat.ceftriaxone.speciality.speciality_indications;

import androidx.fragment.app.Fragment;

public class Indications_item {
    private int id,img;
    private String title;

    public Indications_item(int id, int img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
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


}
