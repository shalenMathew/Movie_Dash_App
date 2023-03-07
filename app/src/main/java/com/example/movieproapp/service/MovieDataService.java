package com.example.movieproapp.service;

import com.example.movieproapp.model.Result;
import com.example.movieproapp.trendingMovieModel.Result2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {


    // end point
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);

    @GET("trending/movie/week")
Call<Result2> getTrendingMovies(@Query("api_key") String apikey);

}
