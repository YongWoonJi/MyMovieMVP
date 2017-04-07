package com.example.yongwoon.mymoviemvp.repository;

import com.example.yongwoon.mymoviemvp.model.PopularResponse;

/**
 * Created by YongWoon on 2017-04-07 007.
 */

public interface IPopularRepository {

    interface GetPopularResponseCallback {

        void onLoaded(PopularResponse results);

        void onFailed(Exception e);
    }


    void getPopularResponse(GetPopularResponseCallback callback);

}
