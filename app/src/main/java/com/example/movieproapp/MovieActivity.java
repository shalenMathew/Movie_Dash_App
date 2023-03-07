package com.example.movieproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;

import com.example.movieproapp.databinding.ActivityMovieBinding;
import com.example.movieproapp.model.MovieModal;

public class MovieActivity extends AppCompatActivity {

    MovieModal movieModal;

    ActivityMovieBinding activityMovieBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

activityMovieBinding= DataBindingUtil.setContentView(this,R.layout.activity_movie);

        Intent i = getIntent();

        if(i!=null){
            movieModal = i.getParcelableExtra("movies");
            activityMovieBinding.setMovie(movieModal);

        }

    }
}