package com.example.quizgamebyasadbek.network;

import com.example.quizgamebyasadbek.models.FlagsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
@GET("/all")
public Call<List<FlagsModel>>getCountries();
}
