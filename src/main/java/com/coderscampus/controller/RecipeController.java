package com.coderscampus.controller;

import com.coderscampus.model.Recipe;
import com.coderscampus.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/all-recipes")
    public String getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipeService.formatRecipes(recipes);
    }

    @GetMapping("/gluten-free")
    public String getGlutenFreeRecipes() {
        List<Recipe> recipes = recipeService.getGlutenFreeRecipes();
        return recipeService.formatRecipes(recipes);
    }

    @GetMapping("/vegan")
    public String getVeganRecipes() {
        List<Recipe> recipes = recipeService.getVeganRecipes();
        return recipeService.formatRecipes(recipes);
    }

    @GetMapping("/vegan-and-gluten-free")
    public String getVeganAndGlutenFreeRecipes() {
        List<Recipe> recipes = recipeService.getVeganAndGlutenFreeRecipes();
        return recipeService.formatRecipes(recipes);
    }

    @GetMapping("/vegetarian")
    public String getVegetarianRecipes() {
        List<Recipe> recipes = recipeService.getVegetarianRecipes();
        return recipeService.formatRecipes(recipes);
    }

    @PostMapping("/update-recipe")
    public void updateRecipe(@RequestBody Recipe recipe) {
        recipeService.updateRecipe(recipe);
    }
}
