package com.coderscampus.service;

import com.coderscampus.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    public List<Recipe> getAllRecipes() {
        // Create sample data
        Recipe recipe1 = new Recipe(30, true, true, "Mix ingredients", 15.0, 10.0, 45, 4, 85.0, "Gluten-Free Pancakes", true, false);
        Recipe recipe2 = new Recipe(20, false, true, "Blend ingredients", 10.0, 8.0, 30, 2, 90.0, "Vegan Smoothie", true, true);
        Recipe recipe3 = new Recipe(40, true, true, "Bake in oven", 20.0, 12.0, 60, 6, 88.0, "Vegetarian Lasagna", false, true);

        // Use setters to update recipe1
        recipe1.setCookingMinutes(35);
        recipe1.setDairyFree(false);
        recipe1.setPreparationMinutes(20.0);
        recipe1.setPricePerServing(12.0);

        // Use getters to retrieve values
        Integer cookingMinutes = recipe1.getCookingMinutes();
        Boolean isDairyFree = recipe1.getDairyFree();
        Double preparationMinutes = recipe1.getPreparationMinutes();
        Double pricePerServing = recipe1.getPricePerServing();

        // Return the list of recipes
        return List.of(recipe1, recipe2, recipe3);
    }

    public void updateRecipe(Recipe recipe) {
        // Use setters to update the recipe object
        recipe.setReadyInMinutes(50);
        recipe.setServings(5);
        recipe.setSpoonacularScore(90.0);
        recipe.setVegan(true);
        recipe.setVegetarian(true);
    }
}
