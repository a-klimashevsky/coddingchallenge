package com.example.imagefeatcher.web;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex Klimashevsky on 16.07.2015.
 */
public class Candidate {
    @SerializedName("name")
    private String mName;

    @SerializedName("position")
    private String mPosition;

    @SerializedName("smallpic")
    private String mSmallImage;

    @SerializedName("lrgpic")
    private String mLargeImage;

    public String getName() {
        return mName;
    }

    public String getPosition() {
        return mPosition;
    }

    public String getSmallImage() {
        return mSmallImage;
    }

    public String getLargeImage() {
        return mLargeImage;
    }
}
