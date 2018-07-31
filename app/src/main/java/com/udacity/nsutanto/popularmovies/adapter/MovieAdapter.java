package com.udacity.nsutanto.popularmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.udacity.nsutanto.popularmovies.R;
import com.udacity.nsutanto.popularmovies.listener.ITaskListener;
import com.udacity.nsutanto.popularmovies.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> mMovies = new ArrayList<>();
    private static ITaskListener mTaskListener;
    private Context context;

    MovieAdapter(ITaskListener taskListener) {
        mTaskListener = taskListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ImageView mPosterView;

        public ViewHolder(View v) {
            super(v);
            mPosterView = v.findViewById(R.id.poster_view);
            v.setOnClickListener(this);
        }

        public void onClick(View v) {
            mTaskListener.StartDetailActivity();
        }
    }


    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String posterPath = mMovies.get(position).GetPosterPath();
        if (posterPath != "") {
            // TODO
            //Picasso.with(context).load("BASE_URL" + "TEST").into(holder.mPosterView);
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

   public void setMovies(ArrayList<Movie> movies) {
        mMovies = movies;
        notifyDataSetChanged();
   }
}

