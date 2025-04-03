package com.khair.wellpick.model;

public class Category {
    int id;
    String name, imageUrl;

    public Category(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getImageUrl() { return imageUrl; }
}

