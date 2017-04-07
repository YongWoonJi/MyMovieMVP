package com.example.yongwoon.mymoviemvp.main;

import android.content.Context;

import com.example.yongwoon.mymoviemvp.model.TopRatedResponse;
import com.example.yongwoon.mymoviemvp.repository.ITopRatedRepository;
import com.example.yongwoon.mymoviemvp.repository.TopRatedRepository_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by YongWoon on 2017-04-06 006.
 */

@EBean
public class TopRatedPresenter implements TopRatedContract.Presenter {

    @RootContext
    Context context;

    private TopRatedContract.View view;

    ITopRatedRepository repository;



    @Override
    public void setView(TopRatedContract.View view) {
        this.view = view;
        this.repository = TopRatedRepository_.getInstance_(context);
    }

    @Override
    public void loadTopRatedMovies() {
        view.showProgress();

        repository.getTopRatedResponse(new ITopRatedRepository.GetTopRatedResponseCallback() {
            @Override
            public void onLoaded(TopRatedResponse results) {
                view.hideProgressBar();
                view.showTopRatedMovies(results.getResults());
            }
        });
    }
}
