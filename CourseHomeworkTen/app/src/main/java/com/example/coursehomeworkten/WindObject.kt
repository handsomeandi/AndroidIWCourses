package com.example.coursehomeworkten

import com.google.gson.annotations.SerializedName




class WindObject{
    @SerializedName("speed")
    private var speed: String? = null

    fun getSpeed(): String? {
        return speed
    }

    fun setSpeed(speed: String?) {
        this.speed = speed
    }
}