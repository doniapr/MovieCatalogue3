package com.doniapr.moviecatalogue.movie;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
    private String title, poster, release_date, overview;
    private float rating, popularity;

    public Movie(JSONObject object) {
        try {
            String title = object.getString("title");
            double rating = object.getDouble("vote_average");
            float popularity = (float) object.getDouble("popularity");
            String release_date = object.getString("release_date");
            String overview = object.getString("overview");

            String poster = "https://image.tmdb.org/t/p/w154" + object.getString("poster_path");

            this.title = title;
            this.rating = (float) rating;
            this.poster = poster;
            this.popularity = popularity;
            this.release_date = release_date;
            this.overview = overview;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
}
