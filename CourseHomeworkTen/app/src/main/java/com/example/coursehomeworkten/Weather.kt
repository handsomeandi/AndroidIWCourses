package com.example.coursehomeworkten

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*


class Weather {

    @SerializedName("main")
    private val main: MainObject? = null

    @SerializedName("weather")
    private val weather: List<WeatherObject>? = null

    @SerializedName("wind")
    private val wind: WindObject? = null

    @SerializedName("sys")
    private val sys: SunObject? = null

    fun getTemp(): String? {
        if (main != null) {
            return main.getTemp()
        }
        return null
    }

    fun getWeatherConditions(): String? {
        if(weather != null){
            return weather[0].getDescription()
        }
        return null
    }

    fun getWindSpeed(): String? {
        if (wind != null) {
            return wind.getSpeed()
        }
        return null
    }


    fun getHumidity(): String? {
        if (main != null) {
            return main.getHumidity()
        }
        return null
    }


    fun getSunrise(): String? {
        if (sys != null) {
            return getDate(sys.getSunrise(), "HH:mm:ss")
        }
        return null
    }


    fun getSunset(): String? {
        if (sys != null) {
            return getDate(sys.getSunset(), "HH:mm:ss")
        }
        return null
    }

    fun getDate(seconds: Long?, dateFormat: String?): String? {
        val formatter = SimpleDateFormat(dateFormat)
        val calendar: Calendar = Calendar.getInstance()
        if(seconds != null){
            calendar.setTimeInMillis(seconds * 1000)
        }
        return formatter.format(calendar.getTime())
    }
}