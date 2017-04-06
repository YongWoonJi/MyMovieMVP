package com.example.yongwoon.mymoviemvp.main;

import com.example.yongwoon.mymoviemvp.model.TopRatedResults;

import java.util.List;

/**
 * Created by YongWoon on 2017-04-06 006.
 */

public interface TopRatedContract {

    interface View {
        void showProgress();

        void showSnackBar(Exception e);

        void hideProgressBar();

        void showTopRatedMovies(List<TopRatedResults> results);
    }

    interface Presenter {
        void setView(View view);

        void loadTopRatedMovies();
    }
}
