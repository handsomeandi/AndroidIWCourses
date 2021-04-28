package com.example.coursehomeworknine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView current_temp, wetness, weather_cond, wind_speed, sunrise, sunset;
    public static final String ERROR = "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        current_temp = findViewById(R.id.currentTempTv);
        wetness = findViewById(R.id.wetnessTv);
        weather_cond = findViewById(R.id.weatherCondTv);
        wind_speed = findViewById(R.id.windSpeedTv);
        sunrise = findViewById(R.id.sunriseTv);
        sunset = findViewById(R.id.sunsetTv);



        NetworkComponent component = DaggerNetworkComponent.builder().networkModule(new NetworkModule()).build();
        ServerApi serverApi = component.getServerApi();

        serverApi.getWeatherData().enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.isSuccessful()){
                    sunset.setText(String.format("%s%s", getString(R.string.sunset), response.body().getSunset()));
                    wetness.setText(String.format("%s%s", getString(R.string.humidity), response.body().getHumidity()));
                    wind_speed.setText(String.format("%s%s", getString(R.string.wind_speed), response.body().getWindSpeed()));
                    weather_cond.setText(String.format("%s%s", getString(R.string.weather_cond), response.body().getWeatherConditions()));
                    sunrise.setText(String.format("%s%s", getString(R.string.sunrise), response.body().getSunrise()));
                    current_temp.setText(String.format("%s%s C", getString(R.string.current_temp), response.body().getTemp()));
                }else{
                    Log.d(ERROR, response.message());
                    Toast.makeText(MainActivity.this, getString(R.string.err) + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d(ERROR, t.getMessage());
                Toast.makeText(MainActivity.this, getString(R.string.err) + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });



    }
}