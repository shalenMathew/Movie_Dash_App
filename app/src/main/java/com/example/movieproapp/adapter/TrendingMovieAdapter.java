package com.example.movieproapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproapp.R;
import com.example.movieproapp.TrendingMovieActivity;
import com.example.movieproapp.databinding.FragmentTrendingBinding;
import com.example.movieproapp.databinding.TrendingMovieListItemBinding;

import com.example.movieproapp.trendingMovieModel.TrendingMovieModal;

import java.util.ArrayList;

public class TrendingMovieAdapter extends RecyclerView.Adapter<TrendingMovieAdapter.ViewHolder> {

    Context context;

    ArrayList<TrendingMovieModal> trendingMovieModalArrayList;

    public TrendingMovieAdapter(Context context, ArrayList<TrendingMovieModal> trendingMovieModalArrayList) {
        this.context = context;
        this.trendingMovieModalArrayList = trendingMovieModalArrayList;
    }

    @NonNull
    @Override
    public TrendingMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TrendingMovieListItemBinding trendingMovieListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.trending_movie_list_item,parent,false);

        return  new ViewHolder(trendingMovieListItemBinding);



    }

    @Override
    public void onBindViewHolder(@NonNull TrendingMovieAdapter.ViewHolder holder, int position) {

        TrendingMovieModal trendingMovieModal = trendingMovieModalArrayList.get(position);

        holder.trendingMovieListItemBinding.setTrendingMovie(trendingMovieModal);


    }

    @Override
    public int getItemCount() {
        return trendingMovieModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

    TrendingMovieListItemBinding trendingMovieListItemBinding;


        public ViewHolder(@NonNull TrendingMovieListItemBinding trendingMovieListItemBinding) {
            super(trendingMovieListItemBinding.getRoot());

            this.trendingMovieListItemBinding = trendingMovieListItemBinding;

            trendingMovieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();



                    if(position!=RecyclerView.NO_POSITION){
                        TrendingMovieModal selectedTrendingMovieModal = trendingMovieModalArrayList.get(position);


                        Intent i = new Intent(context, TrendingMovieActivity.class);
                        i.putExtra("trendingMovie",selectedTrendingMovieModal);
                        context.startActivity(i);


                    }
                }
            });


        }
    }
}
