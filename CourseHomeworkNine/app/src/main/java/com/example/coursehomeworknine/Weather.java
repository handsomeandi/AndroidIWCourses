package com.example.coursehomeworknine;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Weather{
    @SerializedName("main")
    private MainObject main;
    @SerializedName("weather")
    private List<WeatherObject> weather;
    @SerializedName("wind")
    private WindObject wind;
    @SerializedName("sys")
    private SunObject sys;

    public String getTemp() {
        return main.getTemp();
    }

    public String getWeatherConditions() {
        return weather.get(0).getDescription();
    }

    public String getWindSpeed() {
        return wind.getSpeed();
    }


    public String getHumidity() {
        return main.getHumidity();
    }


    public String getSunrise() {
        return getDate(sys.getSunrise(), "HH:mm:ss");
    }


    public String getSunset() {
        return getDate(sys.getSunset(), "HH:mm:ss");
    }

    public static String getDate(long seconds, String dateFormat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds*1000);
        return formatter.format(calendar.getTime());
    }


}
