package com.example.yongwoon.mymoviemvp.main;

import android.content.Context;

import com.example.yongwoon.mymoviemvp.model.PopularResponse;
import com.example.yongwoon.mymoviemvp.repository.IPopularRepository;
import com.example.yongwoon.mymoviemvp.repository.PopularRepository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by YongWoon on 2017-04-05 005.
 */

@EBean
public class PopularPresenter implements PopularContract.Presenter {

    @RootContext
    Context context;

    @Bean(PopularRepository.class)
    IPopularRepository repository;

    private PopularContract.View view;


    @Override
    public void setView(PopularContract.View view) {
        this.view = view;
    }

    @Override
    public void loadPopularMovies() {
        view.showProgress();

        repository.getPopularResponse(new IPopularRepository.GetPopularResponseCallback() {
            @Override
            public void onLoaded(PopularResponse results) {
                view.hideProgress();
                view.showPopularMovies(results.getResults());
            }

            @Override
            public void onFailed(Exception e) {
                view.showSnackBar(e);
            }
        });
    }


}
