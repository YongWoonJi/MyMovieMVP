package com.example.yongwoon.mymoviemvp.repository;

import android.content.Context;

import com.example.yongwoon.mymoviemvp.model.PopularResponse;
import com.example.yongwoon.mymoviemvp.util.Constants;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by YongWoon on 2017-04-07 007.
 */

@EBean(scope = EBean.Scope.Singleton)
public class PopularRepository implements IPopularRepository {

    @RootContext
    Context context;


    @Override
    public void getPopularResponse(final GetPopularResponseCallback callback) {
        Ion.with(context)
                .load(Constants.BASE_URL + "movie/popular")
                .addQuery("api_key", Constants.API_KEY)
                .as(new TypeToken<PopularResponse>(){})
                .setCallback(new FutureCallback<PopularResponse>() {
                    @Override
                    public void onCompleted(Exception e, PopularResponse result) {
                        if (e != null) {
                            return;
                        }

                        if (callback != null) {
                            callback.onLoaded(result);
                        }
                    }
                });
    }

}
