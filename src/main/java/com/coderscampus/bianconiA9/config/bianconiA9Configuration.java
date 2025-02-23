package com.coderscampus.bianconiA9.config;

import com.coderscampus.bianconiA9.repository.RecipeRepository;
import com.coderscampus.bianconiA9.service.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class bianconiA9Configuration {
    @Bean
    public FileService fileService() {
        return new FileService("recipes.txt");
    }

    @Bean
    public RecipeRepository recipeRepository() {
        return new RecipeRepository();
    }
}
