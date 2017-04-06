package com.example.yongwoon.mymoviemvp.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.yongwoon.mymoviemvp.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    ViewPager viewPager;

    @ViewById
    TabLayout tabs;



    @AfterViews
    void initialize() {
        setSupportActionBar(toolbar);
        setupViewPager();
        tabs.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PopularFragment_(), "인기 순위");
        adapter.addFragment(new TopRatedFragment_(), "최고 평점");
        viewPager.setAdapter(adapter);
    }

}
