package com.example.movieproapp.trendingMovieModel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieproapp.R;
import com.example.movieproapp.service.MovieDataService;
import com.example.movieproapp.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingMovieRepository {



    ArrayList<TrendingMovieModal> trendingMovieModalArrayList=new ArrayList<>();

   MutableLiveData<List<TrendingMovieModal>>  mutableLiveData= new MutableLiveData<>();

   Application application;

    public TrendingMovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<TrendingMovieModal>> getTrendingMoviesMutableLiveData() {


        MovieDataService movieDataService = RetrofitInstance.getService();

        Call<Result2> call = movieDataService.getTrendingMovies(application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Result2>() {
            @Override
            public void onResponse(Call<Result2> call, Response<Result2> response) {

                Result2 result2 = response.body();


                if(result2!=null && result2.getResults()!= null){


                    trendingMovieModalArrayList = (ArrayList<TrendingMovieModal>)  result2.getResults();

                    mutableLiveData.setValue(trendingMovieModalArrayList);

                }





            }

            @Override
            public void onFailure(Call<Result2> call, Throwable t) {

            }
        });





        return mutableLiveData;
    }
}
