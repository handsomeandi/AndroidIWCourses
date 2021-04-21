package com.example.coursehomeworknine;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerApi {
    @GET(Urls.WEATHER)
    Call<Weather> getWeatherData();
}
