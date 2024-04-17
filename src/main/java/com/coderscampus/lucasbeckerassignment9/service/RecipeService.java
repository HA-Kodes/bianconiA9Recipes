package com.coderscampus.lucasbeckerassignment9.service;

import com.coderscampus.lucasbeckerassignment9.model.Recipe;
import com.coderscampus.lucasbeckerassignment9.repository.RecipeRepository;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @PostConstruct
    public void init() {
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes",
                        "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan",
                        "Vegetarian")
                .setSkipHeaderRecord(true)
                .setTrim(true)
                .setQuote('"')
                .setEscape('\\')
                .setIgnoreSurroundingSpaces(true)
                .build();
        try {
            CSVParser parser = CSVParser.parse(new FileReader("recipes.txt"), format);
            List<CSVRecord> records = parser.getRecords();

            records.forEach(record -> {
                try {
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

                    recipeRepository.save(recipe);
                } catch (NullPointerException | IllegalArgumentException e) {
                    System.err.println("Error processing record: " + record);
                    System.err.println(e);
                }
            });
        } catch (IOException e) {
            System.err.println("Error while reading and parsing recipes.txt");
            System.err.println(e);
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return recipeRepository.findByGlutenFreeTrue();
    }

    public List<Recipe> getVeganRecipes() {
        return recipeRepository.findByVeganTrue();
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeRepository.findByVeganTrueAndGlutenFreeTrue();
    }

    public List<Recipe> getVegetarianRecipes() {
        return recipeRepository.findByVegetarianTrue();
    }
}
