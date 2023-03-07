package com.example.movieproapp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieproapp.ViewModel.MainActivityViewModel;
import com.example.movieproapp.adapter.TrendingMovieAdapter;
import com.example.movieproapp.databinding.FragmentTrendingBinding;
import com.example.movieproapp.trendingMovieModel.TrendingMovieModal;

import java.util.ArrayList;
import java.util.List;


public class TrendingFragment extends Fragment {


    ArrayList<TrendingMovieModal> list;
    TrendingMovieAdapter trendingMovieAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    MainActivityViewModel mainActivityViewModel;
    FragmentTrendingBinding fragmentTrendingBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentTrendingBinding = FragmentTrendingBinding.inflate(inflater,container,false);

        return  fragmentTrendingBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        trendingPopularMovies();

        swipeRefreshLayout = fragmentTrendingBinding.trendingSwipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                trendingPopularMovies();
            }
        });

    }

    private void trendingPopularMovies() {

        mainActivityViewModel.getAllTrendingMovies().observe(getViewLifecycleOwner(), new Observer<List<TrendingMovieModal>>() {
            @Override
            public void onChanged(List<TrendingMovieModal> trendingMovieModals) {

                list = (ArrayList<TrendingMovieModal>)  trendingMovieModals;
                showOnRecycle();
                swipeRefreshLayout.setRefreshing(false);


            }
        });

    }

    private void showOnRecycle() {

        recyclerView = fragmentTrendingBinding.recycleViewTrending;
        trendingMovieAdapter = new TrendingMovieAdapter(requireContext(),list);

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));
        }else{

            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),4));

        }


        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(trendingMovieAdapter);

        trendingMovieAdapter.notifyDataSetChanged();






    }
}