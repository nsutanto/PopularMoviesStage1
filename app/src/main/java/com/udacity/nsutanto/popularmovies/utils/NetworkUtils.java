package com.udacity.nsutanto.popularmovies.utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public final class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    public static final String BASE_URL = "https://api.themoviedb.org/3";
    public static final String API_MOST_POPULAR = "/movie/popular";
    public static final String API_TOP_RATED = "/movie/top_rated";




    public static URL getUrl(Context context) {
        /*
        if (SunshinePreferences.isLocationLatLonAvailable(context)) {
            double[] preferredCoordinates = SunshinePreferences.getLocationCoordinates(context);
            double latitude = preferredCoordinates[0];
            double longitude = preferredCoordinates[1];
            return buildUrlWithLatitudeLongitude(latitude, longitude);
        } else {
            String locationQuery = SunshinePreferences.getPreferredWeatherLocation(context);
            return buildUrlWithLocationQuery(locationQuery);
        }
        */
        return null;
    }

    private static URL buildUrlWithLatitudeLongitude(Double latitude, Double longitude) {
//        Uri weatherQueryUri = Uri.parse(FORECAST_BASE_URL).buildUpon()
//                .appendQueryParameter(LAT_PARAM, String.valueOf(latitude))
//                .appendQueryParameter(LON_PARAM, String.valueOf(longitude))
//                .appendQueryParameter(FORMAT_PARAM, format)
//                .appendQueryParameter(UNITS_PARAM, units)
//                .appendQueryParameter(DAYS_PARAM, Integer.toString(numDays))
//                .build();
//
//        try {
//            URL weatherQueryUrl = new URL(weatherQueryUri.toString());
//            Log.v(TAG, "URL: " + weatherQueryUrl);
//            return weatherQueryUrl;
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            return null;
//        }
        return null;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response, null if no response
     * @throws IOException Related to network and stream reading
     */
    public static String GetResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            String response = null;
            if (hasInput) {
                response = scanner.next();
            }
            scanner.close();
            return response;
        } finally {
            urlConnection.disconnect();
        }
    }
}
