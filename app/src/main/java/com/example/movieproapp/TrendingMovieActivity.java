package com.example.movieproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.movieproapp.databinding.ActivityTrendingMovieBinding;
import com.example.movieproapp.trendingMovieModel.TrendingMovieModal;

public class TrendingMovieActivity extends AppCompatActivity {

 TrendingMovieModal trendingMovieModal;
    ActivityTrendingMovieBinding activityTrendingMovieBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_movie);

        activityTrendingMovieBinding= DataBindingUtil.setContentView(this,R.layout.activity_trending_movie);

        Intent i = getIntent();

        if(i!=null){

            trendingMovieModal = i.getParcelableExtra("trendingMovie");
            activityTrendingMovieBinding.setTrendingMovie(trendingMovieModal);
        }

    }
}