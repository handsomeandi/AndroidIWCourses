package com.example.coursehomeworknine;

import com.google.gson.annotations.SerializedName;

public class WeatherObject {

    @SerializedName("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
