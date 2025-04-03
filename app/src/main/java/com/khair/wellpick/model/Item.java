package com.khair.wellpick.model;

public class Item {
    int id;
    String name, imageUrl, description;

    public Item(int id, String name, String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }
}
