package com.example.yongwoon.mymoviemvp.main;

import android.content.Context;

import com.example.yongwoon.mymoviemvp.model.PopularResponse;
import com.example.yongwoon.mymoviemvp.util.Constants;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by YongWoon on 2017-04-05 005.
 */

@EBean
public class PopularPresenter implements PopularContract.Presenter {

    @RootContext
    Context context;

    private PopularContract.View view;


    @Override
    public void setView(PopularContract.View view) {
        this.view = view;
    }

    @Override
    public void loadPopularMovies() {
        view.showProgress();

        Ion.with(context)
                .load(Constants.BASE_URL + "movie/popular")
                .addQuery("api_key", Constants.API_KEY)
                .as(new TypeToken<PopularResponse>(){})
                .setCallback(new FutureCallback<PopularResponse>() {
                    @Override
                    public void onCompleted(Exception e, PopularResponse result) {
                        if (e != null) {
                            view.showSnackBar(e);
                            return;
                        }

                        view.hideProgress();
                        view.showPopularMovies(result.getResults());
                    }
                });
    }


}
