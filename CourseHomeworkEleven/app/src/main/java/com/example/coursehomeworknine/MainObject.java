package com.example.coursehomeworknine;

import com.google.gson.annotations.SerializedName;

public class MainObject {
    @SerializedName("temp")
    private String temp;
    @SerializedName("humidity")
    private String humidity;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
