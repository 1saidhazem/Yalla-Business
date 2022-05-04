package com.example.best_ideas.Models;

public class Projects {
    private String name , description ,category ,cost ;
    private byte[] img;

    public Projects(String name, String description, byte[] img ,String cost) { // String category,
        this.name = name;
        this.description = description;
//        this.category = category;
        this.img = img;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
