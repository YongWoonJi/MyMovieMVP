package com.example.yongwoon.mymoviemvp.model;

import java.util.List;

/**
 * Created by YongWoon on 2017-04-06 006.
 */

public class PopularResponse {

    private int page;

    private List<PopularResults> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<PopularResults> getResults() {
        return results;
    }

    public void setResults(List<PopularResults> results) {
        this.results = results;
    }
}
