package com.example.threads.retrofit.network;

import com.example.threads.retrofit.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<News> getTopHeadlines(@Query("country") String country, @Query("apiKey") String apiKey);

}
