package com.coderscampus.bianconiA9.repository;

import com.coderscampus.bianconiA9.domain.Recipe;
import com.coderscampus.bianconiA9.service.FileService;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {
    private final List<Recipe> recipes = new ArrayList<>();

    @Autowired
    private FileService fileService;

    public RecipeRepository() {
    }

    @PostConstruct
    public void loadData() throws IOException {
        Iterable<CSVRecord> records = fileService.readFile();

        for (CSVRecord record : records) {
            Recipe recipe = new Recipe();

            recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
            recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
            recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
            recipe.setInstructions(record.get("Instructions"));
            recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
            recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
            recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
            recipe.setServings(Integer.parseInt(record.get("Servings")));
            recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
            recipe.setTitle(record.get("Title"));
            recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
            recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));

            recipes.add(recipe);
        }
    }

    public List<Recipe> findAll() {
        return recipes;
    }

    public List<Recipe> findByGlutenFree() {
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getGlutenFree()) {
                filteredRecipes.add(recipe);
            }
        }

        return filteredRecipes;
    }

    public List<Recipe> findByVegan() {
       List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getVegan()) {
                filteredRecipes.add(recipe);
            }
        }

        return filteredRecipes;
    }

    public List<Recipe> findByVeganAndGlutenFree() {
       List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getVegan() && recipe.getGlutenFree()) {
                filteredRecipes.add(recipe);
            }
        }

        return filteredRecipes;
    }

    public List<Recipe> findByVegetarian() {
       List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getVegetarian()) {
                filteredRecipes.add(recipe);
            }
        }

        return filteredRecipes;
    }
}
