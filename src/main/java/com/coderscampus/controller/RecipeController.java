package com.coderscampus.controller;

import com.coderscampus.model.Recipe;
import com.coderscampus.model.RecipeResponse;
import com.coderscampus.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/all-recipes")
    public RecipeResponse getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        Map<String, List<Recipe>> categorizedRecipes = new HashMap<>();
        categorizedRecipes.put("All Recipes", recipes);
        return new RecipeResponse("All recipes retrieved successfully", categorizedRecipes);
    }

    @GetMapping("/gluten-free")
    public RecipeResponse getGlutenFreeRecipes() {
        List<Recipe> recipes = recipeService.getGlutenFreeRecipes();
        Map<String, List<Recipe>> categorizedRecipes = new HashMap<>();
        categorizedRecipes.put("Gluten-Free Recipes", recipes);
        return new RecipeResponse("Gluten-free recipes retrieved successfully", categorizedRecipes);
    }

    @GetMapping("/vegan")
    public RecipeResponse getVeganRecipes() {
        List<Recipe> recipes = recipeService.getVeganRecipes();
        Map<String, List<Recipe>> categorizedRecipes = new HashMap<>();
        categorizedRecipes.put("Vegan Recipes", recipes);
        return new RecipeResponse("Vegan recipes retrieved successfully", categorizedRecipes);
    }

    @GetMapping("/vegan-and-gluten-free")
    public RecipeResponse getVeganAndGlutenFreeRecipes() {
        List<Recipe> recipes = recipeService.getVeganAndGlutenFreeRecipes();
        Map<String, List<Recipe>> categorizedRecipes = new HashMap<>();
        categorizedRecipes.put("Vegan and Gluten-Free Recipes", recipes);
        return new RecipeResponse("Vegan and gluten-free recipes retrieved successfully", categorizedRecipes);
    }

    @GetMapping("/vegetarian")
    public RecipeResponse getVegetarianRecipes() {
        List<Recipe> recipes = recipeService.getVegetarianRecipes();
        Map<String, List<Recipe>> categorizedRecipes = new HashMap<>();
        categorizedRecipes.put("Vegetarian Recipes", recipes);
        return new RecipeResponse("Vegetarian recipes retrieved successfully", categorizedRecipes);
    }

    @PostMapping("/update-recipe")
    public void updateRecipe(@RequestBody Recipe recipe) {
        recipeService.updateRecipe(recipe);
    }
}
