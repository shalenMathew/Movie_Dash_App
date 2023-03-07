package com.example.movieproapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproapp.MovieActivity;
import com.example.movieproapp.R;
import com.example.movieproapp.databinding.MovieListItemBinding;
import com.example.movieproapp.model.MovieModal;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<MovieModal> list;

    public Adapter(Context context, ArrayList<MovieModal> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        MovieListItemBinding movieListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_list_item,parent,false);




        return new ViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        MovieModal movieModal = list.get(position);

        holder.movieListItemBinding.setMovie(movieModal);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public   class ViewHolder extends RecyclerView.ViewHolder {

        MovieListItemBinding movieListItemBinding;

        public ViewHolder(@NonNull MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());

            this.movieListItemBinding = movieListItemBinding;


            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int position = getAdapterPosition();



                    if(position!=RecyclerView.NO_POSITION){


                        MovieModal selectedMovie = list.get(position);

                        Intent intent = new Intent(context, MovieActivity.class);
                        intent.putExtra("movies",selectedMovie);

                          context.startActivity(intent);

                    }


                }
            });


        }
    }
}
