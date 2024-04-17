package com.coderscampus.lucasbeckerassignment9.controller;

import com.coderscampus.lucasbeckerassignment9.model.Recipe;
import com.coderscampus.lucasbeckerassignment9.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "Welcome to the recipes app! You can retrieve data from the following endpoints:\n" +
                "/gluten-free\n" +
                "/vegan\n" +
                "/vegan-and-gluten-free\n" +
                "/vegetarian\n" +
                "/all-recipes\n";
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return recipeService.getGlutenFreeRecipes();
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return recipeService.getVeganRecipes();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeService.getVeganAndGlutenFreeRecipes();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return recipeService.getVegetarianRecipes();
    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}
