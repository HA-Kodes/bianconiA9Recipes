package com.coderscampus.lucasbeckerassignment9.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer cookingMinutes;
    private Boolean dairyFree;
    private Boolean glutenFree;
    @Column(length = 4096)
    private String instructions;
    private Double preparationMinutes;
    private Double pricePerServing;
    private Integer readyInMinutes;
    private Integer servings;
    private Double spoonacularScore;
    private String title;
    private Boolean vegan;
    private Boolean vegetarian;

    public Recipe() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getId(), recipe.getId()) &&
                Objects.equals(getCookingMinutes(), recipe.getCookingMinutes()) &&
                Objects.equals(getDairyFree(), recipe.getDairyFree()) &&
                Objects.equals(getGlutenFree(), recipe.getGlutenFree()) &&
                Objects.equals(getInstructions(), recipe.getInstructions()) &&
                Objects.equals(getPreparationMinutes(), recipe.getPreparationMinutes()) &&
                Objects.equals(getPricePerServing(), recipe.getPricePerServing()) &&
                Objects.equals(getReadyInMinutes(), recipe.getReadyInMinutes()) &&
                Objects.equals(getServings(), recipe.getServings()) &&
                Objects.equals(getSpoonacularScore(), recipe.getSpoonacularScore()) &&
                Objects.equals(getTitle(), recipe.getTitle()) &&
                Objects.equals(getVegan(), recipe.getVegan()) &&
                Objects.equals(getVegetarian(), recipe.getVegetarian());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCookingMinutes(), getDairyFree(), getGlutenFree(), getInstructions(),
                getPreparationMinutes(), getPricePerServing(), getReadyInMinutes(), getServings(),
                getSpoonacularScore(), getTitle(), getVegan(), getVegetarian());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", cookingMinutes=" + cookingMinutes +
                ", dairyFree=" + dairyFree +
                ", glutenFree=" + glutenFree +
                ", instructions='" + instructions + '\'' +
                ", preparationMinutes=" + preparationMinutes +
                ", pricePerServing=" + pricePerServing +
                ", readyInMinutes=" + readyInMinutes +
                ", servings=" + servings +
                ", spoonacularScore=" + spoonacularScore +
                ", title='" + title + '\'' +
                ", vegan=" + vegan +
                ", vegetarian=" + vegetarian +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(Integer cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public Boolean getDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(Boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Double getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(Double preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public Double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Double getSpoonacularScore() {
        return spoonacularScore;
    }

    public void setSpoonacularScore(Double spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}
