package com.example.foryoudicodingconsummer.model;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

public class MovieContract {


    private static final String SCHEME = "content";
    public static final String AUTHORITY = "com.example.foryoudicodingsubmissionfour.provider";

    public static String TABLE_MOVIE = "favorite_filminit";
    public MovieContract() {
    }

    public static final class MovieColumns implements BaseColumns {


        public static String title = "title";
        public static String vote_count = "vote_count";
        public static String vote_average = "vote_average";
        public static String popularity = "popularity";
        public static String poster_path = "poster_path";
        public static String original_language = "original_language";
        public static String backdrop_path = "backdrop_path";
        public static String adult = "adult";
        public static String release_date = "release_date";
        public static String overview = "overview";


        public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_MOVIE)
                .build();

    }

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndex(columnName));
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt(cursor.getColumnIndex(columnName));
    }

    public static Double getColumnDouble(Cursor cursor, String columnName) {
        return cursor.getDouble(cursor.getColumnIndex(columnName));
    }
}