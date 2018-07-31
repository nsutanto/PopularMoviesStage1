package com.udacity.nsutanto.popularmovies.listener;

import com.udacity.nsutanto.popularmovies.model.Movie;

import java.net.URL;
import java.util.List;

public interface ITaskListener {
    void OnPostExecute(List<Movie> movies);
    URL GetURL();
    void StartDetailActivity();
}
