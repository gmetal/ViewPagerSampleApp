package com.github.gmetal.tabbedapp;

public class CatImage {

    private String imageUrl;
    private String title;

    public CatImage(final String imageUrl, final String title) {

        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public String getTitle() {

        return title;
    }
}
