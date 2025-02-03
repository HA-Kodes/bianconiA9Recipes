package com.coderscampus.service;

import com.coderscampus.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    public List<Recipe> getAllRecipes() {
        // Dummy data for demonstration
        return List.of(
                new Recipe("Recipe1", true, false, true, false),
                new Recipe("Recipe2", false, true, false, false),
                new Recipe("Recipe3", true, true, true, true)
        );
    }
}
