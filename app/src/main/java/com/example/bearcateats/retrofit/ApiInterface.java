package com.example.bearcateats.retrofit;

import com.example.bearcateats.model.FoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("index.json")
    Call<List<FoodData>> getAllData();
}
