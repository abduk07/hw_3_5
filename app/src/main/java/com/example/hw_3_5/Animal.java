package com.example.hw_3_5;

import java.io.Serializable;

public class Animal implements Serializable {
    private String image;
    private String name;
    private String breed;
    private String color;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Animal(String image, String name, String breed, String color) {
        this.image = image;
        this.name = name;
        this.breed = breed;
        this.color = color;
    }
}
