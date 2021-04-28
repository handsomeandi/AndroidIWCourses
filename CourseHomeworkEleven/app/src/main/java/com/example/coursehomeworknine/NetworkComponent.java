package com.example.coursehomeworknine;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Component(modules = NetworkModule.class)
@Singleton
public interface NetworkComponent {
    Retrofit getRetrofit();
    OkHttpClient.Builder getClient();
    ServerApi getServerApi();

}
