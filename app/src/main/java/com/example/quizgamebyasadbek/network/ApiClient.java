package com.example.quizgamebyasadbek.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
public static final String BASE_URL = "https://restcountries.com/v3.1";
    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
               .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
            .build();
        }
    }
