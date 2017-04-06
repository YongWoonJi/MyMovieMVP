package com.example.yongwoon.mymoviemvp.main;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yongwoon.mymoviemvp.R;
import com.example.yongwoon.mymoviemvp.model.EventData;
import com.example.yongwoon.mymoviemvp.model.PopularResults;
import com.example.yongwoon.mymoviemvp.model.TopRatedResults;
import com.example.yongwoon.mymoviemvp.util.Constants;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by YongWoon on 2017-04-06 006.
 */

@EViewGroup(R.layout.item_movies)
public class MovieItemView extends FrameLayout implements View.OnClickListener {

    Context context;

    EventData item;

    @ViewById
    ImageView moviePoster;

    @ViewById
    TextView movieTitle, movieYear;

    public MovieItemView(Context context) {
        super(context);
        this.context = context;
    }

    public void bind(EventData data) {
        item = data;

        if (data instanceof PopularResults) {
            PopularResults result = (PopularResults) data;
            movieTitle.setText(result.getTitle());
            movieYear.setText(result.getRelease_date());

            Glide.with(context).load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W185 + result.getPoster_path())
                    .placeholder(R.drawable.movieicon)
                    .into(moviePoster);
        } else if (data instanceof TopRatedResults) {
            TopRatedResults result = (TopRatedResults) data;
            movieTitle.setText(result.getTitle());
            movieYear.setText(result.getRelease_date());

            Glide.with(context).load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W185 + result.getPoster_path())
                    .placeholder(R.drawable.movieicon)
                    .into(moviePoster);
        }

        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MovieDetailActivity_.intent(context).data(item).start();
    }
}
