package com.coderscampus.model;

import java.util.List;
import java.util.Map;

public class RecipeResponse {
    private String message;
    private Map<String, List<Recipe>> recipesByCategory;

    public RecipeResponse(String message, Map<String, List<Recipe>> recipesByCategory) {
        this.message = message;
        this.recipesByCategory = recipesByCategory;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, List<Recipe>> getRecipesByCategory() {
        return recipesByCategory;
    }

    public void setRecipesByCategory(Map<String, List<Recipe>> recipesByCategory) {
        this.recipesByCategory = recipesByCategory;
    }

    @Override
    public String toString() {
        StringBuilder formattedOutput = new StringBuilder(message + "\n");
        for (Map.Entry<String, List<Recipe>> entry : recipesByCategory.entrySet()) {
            formattedOutput.append(entry.getKey()).append(":\n");
            for (Recipe recipe : entry.getValue()) {
                formattedOutput.append(" - ").append(recipe.getTitle()).append("\n");
            }
        }
        return formattedOutput.toString();
    }
}
//</create_file>
