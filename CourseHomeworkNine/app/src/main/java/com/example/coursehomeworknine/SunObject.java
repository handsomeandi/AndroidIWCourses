package com.example.coursehomeworknine;

import com.google.gson.annotations.SerializedName;

public class SunObject {

    @SerializedName("sunrise")
    private Long sunrise;
    @SerializedName("sunset")
    private Long sunset;

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }
}
