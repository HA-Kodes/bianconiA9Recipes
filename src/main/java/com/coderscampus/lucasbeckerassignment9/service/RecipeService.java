package com.coderscampus.lucasbeckerassignment9.service;

import com.coderscampus.lucasbeckerassignment9.model.Recipe;
import com.coderscampus.lucasbeckerassignment9.repository.RecipeRepository;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final FileService fileService;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, FileService fileService) {
        this.recipeRepository = recipeRepository;
        this.fileService = fileService;
    }

    @PostConstruct
    public void init() {
        Iterable<Recipe> recipes = fileService.readFile("recipes.txt");
        recipeRepository.saveAll(recipes);
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
