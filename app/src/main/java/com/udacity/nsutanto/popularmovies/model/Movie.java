package com.udacity.nsutanto.popularmovies.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int mId;
    private String mTitle;
    private String mOverview;
    private String mPoster_Path;

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie(int id, String title, String overview, String posterPath) {
        mId = id;
        mTitle = title;
        mOverview = overview;
        mPoster_Path = posterPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mId);
        out.writeString(mTitle);
        out.writeString(mOverview);
        out.writeString(mPoster_Path);
    }

    private Movie(Parcel in) {
        mId = in.readInt();
        mTitle = in.readString();
        mOverview = in.readString();
        mPoster_Path = in.readString();
    }
}