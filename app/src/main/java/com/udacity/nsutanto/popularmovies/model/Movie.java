package com.udacity.nsutanto.popularmovies.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String mTitle;
    private String mImageURL;

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie(String title, String imageURL) {
        mTitle = title;
        mImageURL = imageURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mTitle);
        out.writeString(mImageURL);
    }

    private Movie(Parcel in) {
        mTitle = in.readString();
        mImageURL = in.readString();
    }
}