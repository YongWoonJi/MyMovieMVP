package com.example.yongwoon.mymoviemvp.repository;

import android.content.Context;

import com.example.yongwoon.mymoviemvp.model.TopRatedResponse;
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
public class TopRatedRepository implements ITopRatedRepository {

    @RootContext
    Context context;


    @Override
    public void getTopRatedResponse(final GetTopRatedResponseCallback callback) {
        Ion.with(context)
                .load(Constants.BASE_URL + "movie/top_rated")
                .addQuery("api_key", Constants.API_KEY)
                .as(new TypeToken<TopRatedResponse>(){})
                .setCallback(new FutureCallback<TopRatedResponse>() {
                    @Override
                    public void onCompleted(Exception e, TopRatedResponse result) {
                        if (e != null) {
                            callback.onFailed(e);
                            return;
                        }

                        if (callback != null) {
                            callback.onLoaded(result);
                        }
                    }
                });
    }


}
