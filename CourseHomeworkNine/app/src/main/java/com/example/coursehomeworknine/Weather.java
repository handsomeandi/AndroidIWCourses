package com.example.coursehomeworknine;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Weather{
    @SerializedName("main")
    private JsonObject main;
    @SerializedName("weather")
    private List<JsonObject> weather;
    @SerializedName("wind")
    private JsonObject wind;
    @SerializedName("sys")
    private JsonObject sys;

    public String getTemp() {
        return main.get("temp").getAsString();
    }

    public String getWeatherConditions() {
        return weather.get(0).get("description").getAsString();
    }

    public String getWindSpeed() {
        return wind.get("speed").getAsString();
    }


    public String getHumidity() {
        return main.get("humidity").getAsString();
    }


    public String getSunrise() {
        return getDate(sys.get("sunrise").getAsLong(), "HH:mm:ss");
    }


    public String getSunset() {
        return getDate(sys.get("sunset").getAsLong(), "HH:mm:ss");
    }

    public static String getDate(long seconds, String dateFormat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds*1000);
        return formatter.format(calendar.getTime());
    }


}
