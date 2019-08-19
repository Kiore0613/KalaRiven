package com.example.actividad_eva1.Adapters;

import android.os.Parcel;
import android.os.Parcelable;

public class Hardware implements Parcelable {

    private String hardwareName;
    private int hardware;
    private String hardwareDetail;

    public Hardware(String hardwareName, int hardware, String hardwareDetail) {
        this.hardwareName = hardwareName;
        this.hardware = hardware;
        this.hardwareDetail = hardwareDetail;
    }

    public String getHardwareName() {
        return hardwareName;
    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public int getHardware() {
        return hardware;
    }

    public void setHardware(int hardware) {
        this.hardware = hardware;
    }

    public String getHardwareDetail() {
        return hardwareDetail;
    }

    public void setHardwareDetail(String hardwareDetail) {
        this.hardwareDetail = hardwareDetail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.hardwareName);
        dest.writeInt(this.hardware);
        dest.writeString(this.hardwareDetail);
    }

    protected Hardware(Parcel in) {
        this.hardwareName = in.readString();
        this.hardware = in.readInt();
        this.hardwareDetail = in.readString();
    }

    public static final Parcelable.Creator<Hardware> CREATOR = new Parcelable.Creator<Hardware>() {
        @Override
        public Hardware createFromParcel(Parcel source) {
            return new Hardware(source);
        }

        @Override
        public Hardware[] newArray(int size) {
            return new Hardware[size];
        }
    };
}
