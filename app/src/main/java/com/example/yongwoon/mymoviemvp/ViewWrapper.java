package com.example.yongwoon.mymoviemvp;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by YongWoon on 2017-04-06 006.
 */

public class ViewWrapper extends RecyclerView.ViewHolder {

    private View view;

    public ViewWrapper(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public View getView() {
        return view;
    }
}
