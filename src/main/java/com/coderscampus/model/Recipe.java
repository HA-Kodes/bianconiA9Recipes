package com.coderscampus.model;

public class Recipe {

    private final String recipeName;
    private final boolean glutenFree;
    private final boolean vegan;
    private final boolean vegetarian;

    // Constructor
    public Recipe(String recipeName, boolean glutenFree, boolean vegan, boolean vegetarian, boolean otherAttributes) {
        this.recipeName = recipeName;
        this.glutenFree = glutenFree;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
    }

    // Getters
    public String getRecipeName() {
        return recipeName;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public boolean isVegan() {
        return vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    // Other necessary getters and setters as recipe expands
}
