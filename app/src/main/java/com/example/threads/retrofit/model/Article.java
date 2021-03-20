package com.example.threads.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("source")
    private Source source;

    public Article(String description, String title, Source source) {
        this.title = title;
        this.description = description;
        this.source = source;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
