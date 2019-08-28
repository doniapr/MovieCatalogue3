package com.doniapr.moviecatalogue.tvshow;

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

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
    Context context;
    private ArrayList<TvShow> tvShowData = new ArrayList<>();

    public TvShowAdapter(Context context) {
        this.context = context;
    }

    public void setTvShowData(ArrayList<TvShow> items) {
        tvShowData.clear();
        tvShowData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder tvShowViewHolder, final int i) {
        tvShowViewHolder.txtTitle.setText(tvShowData.get(i).getTitle());
        final float value = (tvShowData.get(i).getRating() / 10) * 5;
        tvShowViewHolder.rating.setRating(value);
        tvShowViewHolder.rating.setIsIndicator(true);
        Glide.with(context)
                .load(tvShowData.get(i).getPoster())
                .into(tvShowViewHolder.imgPoster);

        tvShowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TVSHOW_TITLE, tvShowData.get(i).getTitle());
                intent.putExtra(DetailActivity.EXTRA_TVSHOW_POSTER, tvShowData.get(i).getPoster());
                intent.putExtra(DetailActivity.EXTRA_TVSHOW_OVERVIEW, tvShowData.get(i).getOverview());
                intent.putExtra(DetailActivity.EXTRA_TVSHOW_POPULARITY, tvShowData.get(i).getPopularity());
                intent.putExtra(DetailActivity.EXTRA_TVSHOW_RELEASE_DATE, tvShowData.get(i).getRelease_date());
                intent.putExtra(DetailActivity.EXTRA_TVSHOW_RATING, value);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvShowData.size();
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        RatingBar rating;
        ImageView imgPoster;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            rating = itemView.findViewById(R.id.rating);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }
    }
}
