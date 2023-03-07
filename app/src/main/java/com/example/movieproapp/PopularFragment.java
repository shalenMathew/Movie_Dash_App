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
import com.example.movieproapp.adapter.Adapter;
import com.example.movieproapp.databinding.FragmentPopularBinding;
import com.example.movieproapp.model.MovieModal;

import java.util.ArrayList;
import java.util.List;


public class PopularFragment extends Fragment {


       ArrayList<MovieModal> moviesList;

  Adapter adapter;

    RecyclerView recyclerView;

 SwipeRefreshLayout swipeRefreshLayout;

    MainActivityViewModel activityViewModel;

    FragmentPopularBinding fragmentPopularBinding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        fragmentPopularBinding = FragmentPopularBinding.inflate(inflater,container,false);
        return fragmentPopularBinding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        PopularMovies();


        swipeRefreshLayout = fragmentPopularBinding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                PopularMovies();
            }
        });
    }

    private void PopularMovies() {

        activityViewModel.getAllPopularMovies().observe(getViewLifecycleOwner(), new Observer<List<MovieModal>>() {
            @Override
            public void onChanged(List<MovieModal> movieModals) {

                moviesList= (ArrayList<MovieModal>) movieModals;
                showOnRecycle();
                swipeRefreshLayout.setRefreshing(false);

            }
        });



    }

    private void showOnRecycle() {

        recyclerView = fragmentPopularBinding.recycleView;
        adapter = new Adapter(requireContext(),moviesList);

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),4));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }
}