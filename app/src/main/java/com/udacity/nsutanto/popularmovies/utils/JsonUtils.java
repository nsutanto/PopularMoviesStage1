package com.udacity.nsutanto.popularmovies.utils;

import com.udacity.nsutanto.popularmovies.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String RESULTS = "results";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String OVERVIEW = "overview";
    public static final String POSTER_PATH = "poster_path";

    public static List<Movie> ParseMoviesJSON(String json) throws JSONException {
        ArrayList<Movie> movies = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(json);

        JSONArray results = jsonObj.getJSONArray(RESULTS);

        for (int i = 0; i < results.length(); i++) {
            JSONObject movie = results.getJSONObject(i);

            int id = movie.getInt(ID);
            String title = movie.getString(TITLE);
            String overview = movie.getString(OVERVIEW);
            String poster_path = movie.getString(POSTER_PATH);

            Movie movieData = new Movie(id, title, overview, poster_path);
            movies.add(movieData);
        }

        return movies;
    }
}

