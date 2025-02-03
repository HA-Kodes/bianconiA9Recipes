package com.coderscampus.controller;

import com.coderscampus.model.Recipe;
import com.coderscampus.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // Endpoint to get all gluten-free recipes
    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return recipeService.getAllRecipes().stream()
                .filter(Recipe::isGlutenFree)
                .collect(Collectors.toList());
    }

    // Endpoint to get all vegan recipes
    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return recipeService.getAllRecipes().stream()
                .filter(Recipe::isVegan)
                .collect(Collectors.toList());
    }

    // Endpoint to get all vegan and gluten-free recipes
    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeService.getAllRecipes().stream()
                .filter(recipe -> recipe.isVegan() && recipe.isGlutenFree())
                .collect(Collectors.toList());
    }

@GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return recipeService.getAllRecipes().stream()
                .filter(Recipe::isVegetarian)
                .collect(Collectors.toList());
    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}
