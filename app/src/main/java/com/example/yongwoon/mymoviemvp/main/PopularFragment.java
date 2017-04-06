package com.example.yongwoon.mymoviemvp.main;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.yongwoon.mymoviemvp.R;
import com.example.yongwoon.mymoviemvp.model.PopularResults;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment(R.layout.fragment_popular)
public class PopularFragment extends Fragment implements PopularContract.View {

    @ViewById
    LinearLayout rootLayout;

    @ViewById
    RecyclerView recyclerView;

    @ViewById
    ProgressBar progressBar;

    @Bean
    PopularPresenter presenter;

    @Bean
    PopularAdapter mAdapter;


    @AfterViews
    void init() {
        presenter.setView(this);
        presenter.loadPopularMovies();
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPopularMovies(List<PopularResults> results) {
        mAdapter.setList(results);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    public void showSnackBar(Exception e) {
        Snackbar snackbar = Snackbar.make(rootLayout, e.getMessage(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
