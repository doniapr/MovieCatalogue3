package com.doniapr.moviecatalogue.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doniapr.moviecatalogue.R;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE_TITLE = "extra_movie_title";
    public static final String EXTRA_MOVIE_POSTER = "extra_movie_poster";
    public static final String EXTRA_MOVIE_OVERVIEW = "extra_movie_overview";
    public static final String EXTRA_MOVIE_RATING = "extra_movie_rating";
    public static final String EXTRA_MOVIE_RELEASE_DATE = "extra_movie_release_date";
    public static final String EXTRA_MOVIE_POPULARITY = "extra_movie_popularity";

    public static final String EXTRA_TVSHOW_TITLE = "extra_tvshow_title";
    public static final String EXTRA_TVSHOW_POSTER = "extra_tvshow_poster";
    public static final String EXTRA_TVSHOW_OVERVIEW = "extra_tvshow_overview";
    public static final String EXTRA_TVSHOW_RATING = "extra_tvshow_rating";
    public static final String EXTRA_TVSHOW_RELEASE_DATE = "extra_tvshow_release_date";
    public static final String EXTRA_TVSHOW_POPULARITY = "extra_tvshow_popularity";

    TextView txtTitle, txtSinopsis, txtReleaseDate, txtPopularity;
    RatingBar rating;
    ImageView imgPosterDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTitle = findViewById(R.id.txt_title_detail);
        txtSinopsis = findViewById(R.id.txt_content_sinopsis);
        txtPopularity = findViewById(R.id.txt_content_popularity);
        txtReleaseDate = findViewById(R.id.txt_content_releasedate);
        imgPosterDetail = findViewById(R.id.img_poster_detail);
        rating = findViewById(R.id.rating_detail);

        if (getSupportActionBar() != null) {
            setTitle(getResources().getString(R.string.activity_detail));
        }

        if (getIntent().getStringExtra(EXTRA_MOVIE_TITLE) != null) {
            txtTitle.setText(getIntent().getStringExtra(EXTRA_MOVIE_TITLE));
            txtSinopsis.setText(getIntent().getStringExtra(EXTRA_MOVIE_OVERVIEW));
            txtPopularity.setText(String.valueOf(getIntent().getFloatExtra(EXTRA_MOVIE_POPULARITY, 0)));
            txtReleaseDate.setText(getIntent().getStringExtra(EXTRA_MOVIE_RELEASE_DATE));
            rating.setRating(getIntent().getFloatExtra(EXTRA_MOVIE_RATING, 0));
            rating.setIsIndicator(true);
            Glide.with(this).load(getIntent().getStringExtra(EXTRA_MOVIE_POSTER))
                    .into(imgPosterDetail);
        } else if (getIntent().getStringExtra(EXTRA_TVSHOW_TITLE) != null) {
            txtTitle.setText(getIntent().getStringExtra(EXTRA_TVSHOW_TITLE));
            txtSinopsis.setText(getIntent().getStringExtra(EXTRA_TVSHOW_OVERVIEW));
            txtPopularity.setText(String.valueOf(getIntent().getFloatExtra(EXTRA_TVSHOW_POPULARITY, 0)));
            txtReleaseDate.setText(getIntent().getStringExtra(EXTRA_TVSHOW_RELEASE_DATE));
            rating.setRating(getIntent().getFloatExtra(EXTRA_TVSHOW_RATING, 0));
            rating.setIsIndicator(true);
            Glide.with(this).load(getIntent().getStringExtra(EXTRA_TVSHOW_POSTER))
                    .into(imgPosterDetail);
        }
    }
}
