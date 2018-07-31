package com.udacity.nsutanto.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.udacity.nsutanto.popularmovies.adapter.MovieAdapter;
import com.udacity.nsutanto.popularmovies.listener.ITaskListener;
import com.udacity.nsutanto.popularmovies.model.Movie;
import com.udacity.nsutanto.popularmovies.task.FetchMovieTask;
import com.udacity.nsutanto.popularmovies.utils.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ITaskListener {

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    private ProgressBar mLoadingIndicator;
    private SortBy mSortBy;
    private enum SortBy {
        POPULAR, TOP_RATED
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initRecylerView();

        loadMovieData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_popular) {
            loadMovieData();
        }
        else {
            loadMovieData();
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnPostExecute(ArrayList<Movie> movies) {

        //TextView errorMessage =
        //ProgressBar loadingIndicator
        //RecylclerView movieGrid

        if (movies.isEmpty()) {

        } else {
            mMovieAdapter.setMovies(movies);
        }
    }

    public URL GetURL() {
        if (mSortBy == SortBy.TOP_RATED) {
            return NetworkUtils.BuildTopRatedMovieURL();
        } else {
            return NetworkUtils.BuildPopularMovieURL();
        }
    }

    public void StartDetailActivity(Movie movie) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("movie", movie);
        startActivity(intent);
    }

    private void loadMovieData() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        if (info != null && info.isConnectedOrConnecting()) {
            // Set Loading Indicator
            // Set Error Message
            new FetchMovieTask().execute(this);
        } else {
            // Provide error message
            // Set Loading Indicator
        }
    }

    private void initUI() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSortBy = SortBy.POPULAR;
        //mLoadingIndicator = findViewById(R.id.loading_indicator);
    }

    private void initRecylerView() {
        mRecyclerView = findViewById(R.id.recyclerview_movie);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mMovieAdapter = new MovieAdapter(this);
        mRecyclerView.setAdapter(mMovieAdapter);

    }
}
