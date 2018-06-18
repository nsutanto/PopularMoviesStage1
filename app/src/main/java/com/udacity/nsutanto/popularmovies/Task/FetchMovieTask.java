package com.udacity.nsutanto.popularmovies.Task;

import android.os.AsyncTask;

public class FetchMovieTask extends AsyncTask<String, Void, String[]> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    protected String[] doInBackground(String... params) {

        /* If there's no zip code, there's nothing to look up. *//*
        if (params.length == 0) {
            return null;
        }

        String location = params[0];
        URL weatherRequestUrl = NetworkUtils.buildUrl(location);

        try {
            String jsonWeatherResponse = NetworkUtils
                    .getResponseFromHttpUrl(weatherRequestUrl);

            String[] simpleJsonWeatherData = OpenWeatherJsonUtils
                    .getSimpleWeatherStringsFromJson(MainActivity.this, jsonWeatherResponse);

            return simpleJsonWeatherData;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }*/
        return null;
    }

    @Override
    protected void onPostExecute(String[] weatherData) {
        /*mLoadingIndicator.setVisibility(View.INVISIBLE);
        if (weatherData != null) {
            showWeatherDataView();
            // COMPLETED (45) Instead of iterating through every string, use mForecastAdapter.setWeatherData and pass in the weather data
            mForecastAdapter.setWeatherData(weatherData);
        } else {
            showErrorMessage();
        }*/
    }
}