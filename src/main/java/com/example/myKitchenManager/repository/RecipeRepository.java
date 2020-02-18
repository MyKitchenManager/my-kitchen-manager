package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.repository.entity.Recipe;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Recipe findById(int id);

    @Modifying
    @Transactional
    @Query(
            value  = "delete from recipe where recipe.recipe_id = ?1",
            nativeQuery = true
    )
    void deleteByRecipeId(int recipeId);
}