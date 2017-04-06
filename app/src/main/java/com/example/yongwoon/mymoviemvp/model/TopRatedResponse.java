package com.example.yongwoon.mymoviemvp.model;

import java.util.List;

/**
 * Created by YongWoon on 2017-04-06 006.
 */

public class TopRatedResponse {

    private int page;

    private List<TopRatedResults> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<TopRatedResults> getResults() {
        return results;
    }

    public void setResults(List<TopRatedResults> results) {
        this.results = results;
    }
}
