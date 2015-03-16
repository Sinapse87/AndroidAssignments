package com.assignment.luca.assignment2.model;

/**
 * Created by Luca on 16/03/15.
 */
public class FruitImage {

    private int id;

    private String description;

    public FruitImage(int id,String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
