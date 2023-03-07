package com.example.movieproapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieproapp.model.MovieModal;
import com.example.movieproapp.model.MovieRepository;
import com.example.movieproapp.trendingMovieModel.TrendingMovieModal;
import com.example.movieproapp.trendingMovieModel.TrendingMovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {


    private MovieRepository movieRepository;
    private TrendingMovieRepository trendingMovieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
        this.trendingMovieRepository= new TrendingMovieRepository(application);
    }


    public LiveData<List<MovieModal>> getAllPopularMovies(){
        return  movieRepository.getMutableLiveData();
    }

    public LiveData<List<TrendingMovieModal>> getAllTrendingMovies(){

        return trendingMovieRepository.getTrendingMoviesMutableLiveData();

    }

}
