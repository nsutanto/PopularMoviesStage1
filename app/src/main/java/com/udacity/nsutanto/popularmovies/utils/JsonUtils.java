package com.udacity.nsutanto.popularmovies.utils;

import com.udacity.nsutanto.popularmovies.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static final String BASE_URL = "https://api.themoviedb.org/3";
    public static final String API_MOST_POPULAR = "/movie/popular";
    public static final String API_TOP_RATED = "/movie/top_rated";



    public static List<Movie> ParseMoviesJS(String json) throws JSONException {

        ArrayList<Movie> movies = new ArrayList<>();

        JSONObject jsonObj = new JSONObject(json);

        return movies;
    }

    private static List<String> convertToList(JSONArray jsonArray) throws JSONException {
        List<String> strings = new ArrayList<String>();

        for (int i = 0; i < jsonArray.length(); i++) {
            strings.add(jsonArray.optString(i));
        }
        return strings;
    }
}

