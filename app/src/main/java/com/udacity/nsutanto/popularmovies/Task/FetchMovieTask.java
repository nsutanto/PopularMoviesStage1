package com.udacity.nsutanto.popularmovies.task;

import android.os.AsyncTask;
import com.udacity.nsutanto.popularmovies.listener.TaskListener;

import java.net.URL;

public class FetchMovieTask extends AsyncTask<String, Integer, String> {

    private TaskListener mTaskListener;

    public FetchMovieTask(TaskListener listener) {
        mTaskListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        /*
        try {
            String jsonWeatherResponse = NetworkUtils
                    .getResponseFromHttpUrl(weatherRequestUrl);

            String[] simpleJsonWeatherData = OpenWeatherJsonUtils
                    .getSimpleWeatherStringsFromJson(MainActivity.this, jsonWeatherResponse);

            return simpleJsonWeatherData;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        */
        return "Test";
    }

    @Override
    protected void onPostExecute(String result) {
        //super.onPostExecute();
        //mTaskListener.onPostExecute();
    }
}