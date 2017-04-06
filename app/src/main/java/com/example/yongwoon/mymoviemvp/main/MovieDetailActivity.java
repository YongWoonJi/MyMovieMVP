package com.example.yongwoon.mymoviemvp.main;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.yongwoon.mymoviemvp.R;
import com.example.yongwoon.mymoviemvp.model.EventData;
import com.example.yongwoon.mymoviemvp.model.PopularResults;
import com.example.yongwoon.mymoviemvp.model.TopRatedResults;
import com.example.yongwoon.mymoviemvp.util.Constants;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_movie_detail)
public class MovieDetailActivity extends AppCompatActivity {

    @ViewById
    ImageView coverImage, detailPoster;

    @ViewById
    TextView detailTitle, releaseDate, detailOverview;

    @Extra
    EventData data;


    @AfterViews
    void init() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        if (data instanceof PopularResults) {
            PopularResults result = (PopularResults) data;
            detailTitle.setText(result.getTitle());
            releaseDate.setText(result.getRelease_date());
            detailOverview.setText(result.getOverview());
            Glide.with(this)
                    .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W92 + result.getPoster_path())
                    .placeholder(R.drawable.movieicon)
                    .into(detailPoster);

            Glide.with(this)
                    .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W780 + result.getBackdrop_path())
                    .bitmapTransform(new CenterCrop(this))
                    .into(coverImage);

        } else if (data instanceof TopRatedResults) {
            TopRatedResults result = (TopRatedResults) data;
            detailTitle.setText(result.getTitle());
            releaseDate.setText(result.getRelease_date());
            detailOverview.setText(result.getOverview());
            Glide.with(this)
                    .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W92 + result.getPoster_path())
                    .placeholder(R.drawable.movieicon)
                    .into(detailPoster);

            Glide.with(this)
                    .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W780 + result.getBackdrop_path())
                    .bitmapTransform(new CenterCrop(this))
                    .into(coverImage);
        }

    }


}
