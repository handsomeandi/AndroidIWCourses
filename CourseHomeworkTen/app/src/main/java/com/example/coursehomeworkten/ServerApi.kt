package com.example.coursehomeworkten

import retrofit2.Call
import retrofit2.http.GET

interface ServerApi {
    @GET(Urls.WEATHER)
    suspend fun getWeatherData(): Weather?
}