package com.example.yongwoon.mymoviemvp.main;

import com.example.yongwoon.mymoviemvp.model.PopularResults;

import java.util.List;

/**
 * Created by YongWoon on 2017-04-05 005.
 */

public interface PopularContract {

    interface View {
        void showProgress();

        void hideProgress();

        void showPopularMovies(List<PopularResults> results);

        void showSnackBar(Exception e);
    }


    interface Presenter {
        void setView(View view);

        void loadPopularMovies();
    }
}
