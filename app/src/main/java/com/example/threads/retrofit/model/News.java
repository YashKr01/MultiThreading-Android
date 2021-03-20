package com.example.threads.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<Article> articleList;

    public News(String status, int totalResults, List<Article> articleList) {
        this.status = status;
        this.totalResults = totalResults;
        this.articleList = articleList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
