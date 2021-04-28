package com.example.coursehomeworknine;


import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient.Builder client){
        client.connectTimeout(30, TimeUnit.SECONDS);
        client.writeTimeout(60, TimeUnit.SECONDS);
        client.readTimeout(60, TimeUnit.SECONDS);

        return new Retrofit.Builder().baseUrl(Urls.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Singleton
    @Provides
    public OkHttpClient.Builder provideClient(){
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    public ServerApi provideServerApi(Retrofit retrofit){
        return retrofit.create(ServerApi.class);
    }


}
