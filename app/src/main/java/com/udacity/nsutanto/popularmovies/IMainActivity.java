package com.udacity.nsutanto.popularmovies;

import android.widget.ProgressBar;
import android.widget.TextView;

import com.udacity.nsutanto.popularmovies.adapter.MovieAdapter;
import com.udacity.nsutanto.popularmovies.model.Movie;


public interface IMainActivity {
    String GetSortBy();
    MovieAdapter GetMovieAdapter();
    TextView GetErrorMessage();
    ProgressBar GetLoadingIndicator();
    //RecylerView GetMovieGrid();
    void StartDetailActivity(Movie movie);

}
