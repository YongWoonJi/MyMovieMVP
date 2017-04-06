package com.example.yongwoon.mymoviemvp.main;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.yongwoon.mymoviemvp.R;
import com.example.yongwoon.mymoviemvp.model.TopRatedResults;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment(R.layout.fragment_top_rated)
public class TopRatedFragment extends Fragment implements TopRatedContract.View {

    @ViewById
    RecyclerView recyclerView;

    @ViewById
    ProgressBar progressBar;

    @Bean
    TopRatedPresenter presenter;

    @Bean
    TopRatedAdapter mAdapter;

    @AfterViews
    void init() {
        presenter.setView(this);
        presenter.loadTopRatedMovies();
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showSnackBar(Exception e) {
        Snackbar snackbar = Snackbar.make(getView(), e.getMessage(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTopRatedMovies(List<TopRatedResults> results) {
        mAdapter.setList(results);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }
}
