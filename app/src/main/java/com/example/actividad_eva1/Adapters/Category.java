package com.example.actividad_eva1.Adapters;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Category implements Parcelable {

    private int category;
    private ArrayList<Hardware> hardwares;
    private String categoryName;

    public Category(int category, ArrayList<Hardware> hardwares, String categoryName) {
        this.category = category;
        this.hardwares = hardwares;
        this.categoryName = categoryName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public ArrayList<Hardware> getHardwares() {
        return hardwares;
    }

    public void setHardwares(ArrayList<Hardware> hardwares) {
        this.hardwares = hardwares;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.category);
        dest.writeList(this.hardwares);
        dest.writeString(this.categoryName);
    }

    protected Category(Parcel in) {
        this.category = in.readInt();
        this.hardwares = new ArrayList<Hardware>();
        in.readList(this.hardwares, Hardware.class.getClassLoader());
        this.categoryName = in.readString();
    }

    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
