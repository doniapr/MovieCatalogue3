package com.doniapr.moviecatalogue.movie;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doniapr.moviecatalogue.R;
import com.doniapr.moviecatalogue.activity.DetailActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    Context context;
    private ArrayList<Movie> movieData = new ArrayList<>();

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<Movie> items) {
        movieData.clear();
        movieData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.txtTitle.setText(movieData.get(i).getTitle());
        final float value = (movieData.get(i).getRating() / 10) * 5;
        movieViewHolder.rating.setRating(value);
        movieViewHolder.rating.setIsIndicator(true);
        Glide.with(context)
                .load(movieData.get(i).getPoster())
                .into(movieViewHolder.imgPoster);

        movieViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE_TITLE, movieData.get(movieViewHolder.getAdapterPosition()).getTitle());
                intent.putExtra(DetailActivity.EXTRA_MOVIE_POSTER, movieData.get(i).getPoster());
                intent.putExtra(DetailActivity.EXTRA_MOVIE_OVERVIEW, movieData.get(i).getOverview());
                intent.putExtra(DetailActivity.EXTRA_MOVIE_POPULARITY, movieData.get(i).getPopularity());
                intent.putExtra(DetailActivity.EXTRA_MOVIE_RELEASE_DATE, movieData.get(i).getRelease_date());
                intent.putExtra(DetailActivity.EXTRA_MOVIE_RATING, value);
                movieViewHolder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        RatingBar rating;
        ImageView imgPoster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            rating = itemView.findViewById(R.id.rating);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }
    }
}
