package com.coderscampus.lucasbeckerassignment9.service;

import com.coderscampus.lucasbeckerassignment9.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @PostConstruct
    public void init() throws IOException {
        try {
            List<String> lines = Files.readAllLines(Paths.get("recipes.txt"));
            CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().setDelimiter(',').build();
            CSVParser parser = CSVParser.parse(new FileReader("recipes.txt"), format);
            List<CSVRecord> records = parser.getRecords();
            records.parallelStream().forEach(record -> {
                Recipe recipe = new Recipe();
                recipe.setCookingMinutes(Integer.parseInt(record.get("cookingMinutes").trim()));
                recipe.setDairyFree(Boolean.parseBoolean(record.get("dairyFree").trim()));
                recipe.setGlutenFree(Boolean.parseBoolean(record.get("glutenFree").trim()));
                recipe.setInstructions(record.get("instructions").trim());
                recipe.setPreparationMinutes(Double.parseDouble(record.get("preparationMinutes").trim()));
                recipe.setPricePerServing(Double.parseDouble(record.get("pricePerServing").trim()));
                recipe.setReadyInMinutes(Integer.parseInt(record.get("readyInMinutes").trim()));
                recipe.setServings(Integer.parseInt(record.get("servings").trim()));
                recipe.setSpoonacularScore(Double.parseDouble(record.get("spoonacularScore").trim()));
                recipe.setTitle(record.get("title").trim());
                recipe.setVegan(Boolean.parseBoolean(record.get("vegan").trim()));
                recipe.setVegetarian(Boolean.parseBoolean(record.get("vegetarian").trim()));
                recipeRepository.save(recipe);
            });
        } catch (IOException | SecurityException | InvalidPathException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return recipeRepository.findByGlutenFreeTrue();
    }

}
