package com.udacity.nsutanto.popularmovies.task;

import android.os.AsyncTask;
import com.udacity.nsutanto.popularmovies.listener.TaskListener;
import com.udacity.nsutanto.popularmovies.utils.NetworkUtils;

import java.net.URL;

public class FetchMovieTask extends AsyncTask<URL, Integer, String> {

    private TaskListener mTaskListener;

    public FetchMovieTask(TaskListener listener) {
        mTaskListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(URL... params) {

        String jsonResponse;
        URL requestURL = params[0];

        try {
            jsonResponse = NetworkUtils.GetResponseFromHttpUrl(requestURL);

            return jsonResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //super.onPostExecute();
        mTaskListener.onPostExecute();
    }
}