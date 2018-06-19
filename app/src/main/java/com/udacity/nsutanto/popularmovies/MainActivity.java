package com.udacity.nsutanto.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.udacity.nsutanto.popularmovies.adapter.MovieAdapter;
import com.udacity.nsutanto.popularmovies.listener.TaskListener;

public class MainActivity extends AppCompatActivity implements TaskListener {

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_popular) {
            // TODO: Fetch Popular Movie
        }
        else {
            // TODO: Fetch Top Rated Movie
        }

        return super.onOptionsItemSelected(item);
    }

    public void onPostExecute() {

    }

    private void init() {
        /*
         * Using findViewById, we get a reference to our RecyclerView from xml. This allows us to
         * do things like set the adapter of the RecyclerView and toggle the visibility.
         *//*
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_forecast);

        *//* This TextView is used to display errors and will be hidden if there are no errors *//*
        mErrorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);

        // COMPLETED (38) Create layoutManager, a LinearLayoutManager with VERTICAL orientation and shouldReverseLayout == false
        *//*
         * LinearLayoutManager can support HORIZONTAL or VERTICAL orientations. The reverse layout
         * parameter is useful mostly for HORIZONTAL layouts that should reverse for right to left
         * languages.
         *//*
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        // COMPLETED (41) Set the layoutManager on mRecyclerView
        mRecyclerView.setLayoutManager(layoutManager);

        // COMPLETED (42) Use setHasFixedSize(true) on mRecyclerView to designate that all items in the list will have the same size
        *//*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         *//*
        mRecyclerView.setHasFixedSize(true);

        // COMPLETED (43) set mForecastAdapter equal to a new ForecastAdapter
        *//*
         * The ForecastAdapter is responsible for linking our weather data with the Views that
         * will end up displaying our weather data.
         *//*
        mForecastAdapter = new ForecastAdapter();

        // COMPLETED (44) Use mRecyclerView.setAdapter and pass in mForecastAdapter
        *//* Setting the adapter attaches it to the RecyclerView in our layout. *//*
        mRecyclerView.setAdapter(mForecastAdapter);

        *//*
         * The ProgressBar that will indicate to the user that we are loading data. It will be
         * hidden when no data is loading.
         *
         * Please note: This so called "ProgressBar" isn't a bar by default. It is more of a
         * circle. We didn't make the rules (or the names of Views), we just follow them.
         *//*
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        *//* Once all of our views are setup, we can load the weather data. *//*
        loadMovieData();*/
    }
}
