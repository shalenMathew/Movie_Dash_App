package com.example.movieproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.content.res.Configuration;
import android.os.Bundle;

import com.example.movieproapp.ViewModel.MainActivityViewModel;
import com.example.movieproapp.adapter.Adapter;
import com.example.movieproapp.databinding.ActivityMainBinding;
import com.example.movieproapp.model.MovieModal;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar = findViewById(R.id.bottom_navBar);
        chipNavigationBar.setItemSelected(R.id.popularMenu, true);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, (new PopularFragment())).commit();



bottomMenu();

    }

    private void bottomMenu() {

chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
    @Override
    public void onItemSelected(int i) {
        Fragment fragment = null;
        switch (i){
            case R.id.popularMenu:fragment=new PopularFragment();
            break;
            case R.id.trendingMenu:fragment = new TrendingFragment();
            break;

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,fragment).commit();

    }
});

    }

    }
