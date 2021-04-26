package com.example.coursehomeworkten

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    var current_temp:TextView? = null
    var wetness:TextView? = null
    var weather_cond:TextView? = null
    var wind_speed:TextView? = null
    var sunrise:TextView? = null
    var sunset:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        current_temp = findViewById(R.id.currentTempTv)
        wetness = findViewById(R.id.wetnessTv)
        weather_cond = findViewById(R.id.weatherCondTv)
        wind_speed = findViewById(R.id.windSpeedTv)
        sunrise = findViewById(R.id.sunriseTv)
        sunset = findViewById(R.id.sunsetTv)

        setUpObserver()

    }

    private fun getWeather() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getServerApi.getWeatherData()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    private fun setUpObserver() {
        getWeather().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {

                    Status.SUCCESS -> {
                         resource.data?.let {
                                weatherData -> setTextForTV(weatherData)
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }

            }
        })
    }

    private fun setTextForTV(weatherData:Weather?){
        current_temp?.text = String.format("%s%s",getString(R.string.current_temp), weatherData?.getTemp())
        wind_speed?.text =String.format("%s%s",getString(R.string.wind_speed), weatherData?.getWindSpeed());
        wetness?.text = String.format("%s%s",getString(R.string.humidity), weatherData?.getHumidity());
        weather_cond?.text = String.format("%s%s",getString(R.string.weather_cond), weatherData?.getWeatherConditions());
        sunset?.text = String.format("%s%s",getString(R.string.sunset), weatherData?.getSunset());
        sunrise?.text =String.format("%s%s",getString(R.string.sunrise), weatherData?.getSunrise());
    }

    val getServerApi: ServerApi = getRetrofit().create(ServerApi::class.java)


    private fun getRetrofit() : Retrofit {
        val client = OkHttpClient.Builder()
        client.connectTimeout(30, TimeUnit.SECONDS)
        client.writeTimeout(60, TimeUnit.SECONDS)
        client.readTimeout(60, TimeUnit.SECONDS)

        return Retrofit.Builder().baseUrl(Urls.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}