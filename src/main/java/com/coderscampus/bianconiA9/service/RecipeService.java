package com.coderscampus.bianconiA9.service;

import com.coderscampus.bianconiA9.domain.Recipe;
import com.coderscampus.bianconiA9.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return recipeRepository.findByGlutenFree();
    }

  public List<Recipe> getVeganRecipes() {
        return recipeRepository.findByVegan();
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeRepository.findByVeganAndGlutenFree();
    }

    public List<Recipe> getVegetarianRecipes() {
        return recipeRepository.findByVegetarian();
    }
}
