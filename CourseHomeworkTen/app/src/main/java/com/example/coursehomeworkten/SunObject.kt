package com.example.coursehomeworkten

import com.google.gson.annotations.SerializedName




class SunObject {
    @SerializedName("sunrise")
    private var sunrise: Long? = null

    @SerializedName("sunset")
    private var sunset: Long? = null

    fun getSunset(): Long? {
        return sunset
    }

    fun setSunset(sunset: Long?) {
        this.sunset = sunset
    }

    fun getSunrise(): Long? {
        return sunrise
    }

    fun setSunrise(sunrise: Long?) {
        this.sunrise = sunrise
    }
}