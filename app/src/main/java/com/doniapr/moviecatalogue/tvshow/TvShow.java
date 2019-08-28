package com.doniapr.moviecatalogue.tvshow;

import org.json.JSONException;
import org.json.JSONObject;

public class TvShow {
    private String title, poster, release_date, overview;
    private float rating, popularity;

    TvShow(JSONObject object) {
        try {
            String title = object.getString("name");
            double rating = object.getDouble("vote_average");
            float popularity = (float) object.getDouble("popularity");
            String release_date = object.getString("first_air_date");
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
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
