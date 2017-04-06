package com.example.yongwoon.mymoviemvp.main;

import android.content.Context;

import com.example.yongwoon.mymoviemvp.model.TopRatedResponse;
import com.example.yongwoon.mymoviemvp.util.Constants;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by YongWoon on 2017-04-06 006.
 */

@EBean
public class TopRatedPresenter implements TopRatedContract.Presenter {

    @RootContext
    Context context;

    TopRatedContract.View view;

    @Override
    public void setView(TopRatedContract.View view) {
        this.view = view;
    }

    @Override
    public void loadTopRatedMovies() {
        view.showProgress();

        Ion.with(context)
                .load(Constants.BASE_URL + "movie/top_rated")
                .addQuery("api_key", Constants.API_KEY)
                .as(new TypeToken<TopRatedResponse>(){})
                .setCallback(new FutureCallback<TopRatedResponse>() {
                    @Override
                    public void onCompleted(Exception e, TopRatedResponse result) {
                        if (e != null) {
                            view.showSnackBar(e);
                            return;
                        }

                        view.hideProgressBar();
                        view.showTopRatedMovies(result.getResults());
                    }
                });
    }
}
