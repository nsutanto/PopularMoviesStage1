package com.udacity.nsutanto.popularmovies.task;

import android.os.AsyncTask;
import com.udacity.nsutanto.popularmovies.listener.ITaskListener;
import com.udacity.nsutanto.popularmovies.model.Movie;
import com.udacity.nsutanto.popularmovies.utils.JsonUtils;
import com.udacity.nsutanto.popularmovies.utils.NetworkUtils;

import java.net.URL;
import java.util.List;

public class FetchMovieTask extends AsyncTask<ITaskListener, Void, List<Movie>> {

    private ITaskListener mTaskListener;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Movie> doInBackground(ITaskListener... taskListeners) {

        String jsonResponse;
        mTaskListener = taskListeners[0];
        URL url = mTaskListener.GetURL();

        try {
            jsonResponse = NetworkUtils.GetResponseFromHttpUrl(url);
            List<Movie> movies = JsonUtils.ParseMoviesJSON(jsonResponse);
            return movies;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        mTaskListener.OnPostExecute(movies);
    }
}