package com.example.coursehomeworknine;

import com.google.gson.annotations.SerializedName;

public class WindObject {

    @SerializedName("speed")
    private String speed;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
