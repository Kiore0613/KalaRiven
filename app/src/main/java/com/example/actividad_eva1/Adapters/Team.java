package com.example.actividad_eva1.Adapters;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Team implements Serializable {

    private String name;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    private int image;

    public Team(String name,  int image, String info) {
        this.name = name;
        this.info = info;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}




