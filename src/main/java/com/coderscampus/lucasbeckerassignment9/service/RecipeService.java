package com.coderscampus.lucasbeckerassignment9.service;

import com.coderscampus.lucasbeckerassignment9.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
}
