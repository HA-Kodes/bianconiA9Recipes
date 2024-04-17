package com.coderscampus.lucasbeckerassignment9.repository;

import com.coderscampus.lucasbeckerassignment9.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByGlutenFreeTrue();

    List<Recipe> findByVeganTrue();

    List<Recipe> findByVeganTrueAndGlutenFreeTrue();

    List<Recipe> findByVegetarianTrue();
}
