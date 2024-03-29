package com.example.foryoudicodingconsummer.model;

import android.database.Cursor;

import static com.example.foryoudicodingconsummer.model.MovieContract.getColumnInt;
import static com.example.foryoudicodingconsummer.model.MovieContract.getColumnString;
import static com.example.foryoudicodingconsummer.model.MovieContract.MovieColumns;


public class FilmInit {

    public String title;
    public String vote_count;
    public String vote_average;
    public String popularity;
    public String poster_path;
    public String original_language;
    public String backdrop_path;
    public String adult;
    public String release_date;
    public String overview;
    private int id;

    public FilmInit(String title, String vote_count, String vote_average, String popularity, String poster_path, String original_language, String backdrop_path, String adult, String release_date, String overview, int id) {
        this.title = title;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.release_date = release_date;
        this.overview = overview;
        this.id = id;
    }


    public FilmInit(Cursor cursor) {
        this.id = getColumnInt(cursor, MovieColumns._ID);
        this.title = getColumnString(cursor, MovieColumns.title);
        this.vote_count = getColumnString(cursor, MovieColumns.vote_count);
        this.vote_average = getColumnString(cursor, MovieColumns.vote_average);
        this.popularity = getColumnString(cursor, MovieColumns.popularity);
        this.poster_path = getColumnString(cursor, MovieColumns.poster_path);
        this.original_language = getColumnString(cursor, MovieColumns.original_language);
        this.backdrop_path = getColumnString(cursor, MovieColumns.backdrop_path);
        this.adult = getColumnString(cursor, MovieColumns.adult);
        this.release_date = getColumnString(cursor, MovieColumns.release_date);
        this.overview = getColumnString(cursor, MovieColumns.overview);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }



}
