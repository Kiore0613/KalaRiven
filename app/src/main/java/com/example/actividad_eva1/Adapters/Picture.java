package com.example.actividad_eva1.Adapters;

import android.graphics.Bitmap;

public class Picture {
    Bitmap picture;

    public Picture(Bitmap picture) {
        this.picture = picture;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }
}