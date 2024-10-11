package com.example.a4mp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Heroes implements Parcelable {
    private String name;
    private String description;
    private int Photo;

    public Heroes(Parcel in){
        this.name = in.readString();
        this.description = in.readString();
        this.Photo = in.readInt();
    }

    public Heroes() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.Photo);
    }

    public static final Parcelable.Creator<Heroes> CREATOR= new Parcelable.Creator<Heroes>(){

        @Override
        public Heroes createFromParcel(Parcel source) {
            return new Heroes(source);
        }

        @Override
        public Heroes[] newArray(int size) {
            return new Heroes[0];
        }
    };
}
