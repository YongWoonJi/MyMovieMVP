package com.example.yongwoon.mymoviemvp.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.yongwoon.mymoviemvp.BaseAdapter;
import com.example.yongwoon.mymoviemvp.ViewWrapper;
import com.example.yongwoon.mymoviemvp.model.PopularResults;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by YongWoon on 2017-04-06 006.
 */

@EBean
public class PopularAdapter extends BaseAdapter {

    @RootContext
    Context context;

    private List<PopularResults> list;

    public void setList(List<PopularResults> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    protected View onCreateItemView(ViewGroup parent, int viewType) {
        return MovieItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper holder, int position) {
        MovieItemView view = (MovieItemView) holder.getView();
        view.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
