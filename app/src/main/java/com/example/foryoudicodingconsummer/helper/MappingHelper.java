package com.example.foryoudicodingconsummer.helper;

import android.database.Cursor;
import static android.provider.BaseColumns._ID;
import com.example.foryoudicodingconsummer.model.FilmInit;
import com.example.foryoudicodingconsummer.model.MovieContract;

import java.util.ArrayList;


public class MappingHelper {

    public static ArrayList<FilmInit> mapCursorMovieToArrayList(Cursor cursor) {
        ArrayList<FilmInit> filmInits = new ArrayList<>();
        while (cursor.moveToNext()) {

            int id = cursor.getInt(cursor.getColumnIndexOrThrow(_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.title));
            String vote_count = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.vote_count));
            String vote_average = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.vote_average));
            String popularity = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.popularity));
            String poster_path = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.poster_path));
            String original_language = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.original_language));
            String backdrop_path = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.backdrop_path));
            String adult = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.adult));
            String release_date = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.release_date));
            String overview = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieColumns.overview));

            filmInits.add(new FilmInit(title, vote_count, vote_average, popularity, poster_path, original_language,
                    backdrop_path, adult,release_date,overview,id));
        }
        return filmInits;
    }
}