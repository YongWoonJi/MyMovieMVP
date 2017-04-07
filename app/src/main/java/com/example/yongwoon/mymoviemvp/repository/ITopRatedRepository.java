package com.example.yongwoon.mymoviemvp.repository;

import com.example.yongwoon.mymoviemvp.model.TopRatedResponse;

/**
 * Created by YongWoon on 2017-04-07 007.
 */

public interface ITopRatedRepository {

    interface GetTopRatedResponseCallback {

        void onLoaded(TopRatedResponse results);

        void onFailed(Exception e);
    }

    void getTopRatedResponse(GetTopRatedResponseCallback callback);

}
