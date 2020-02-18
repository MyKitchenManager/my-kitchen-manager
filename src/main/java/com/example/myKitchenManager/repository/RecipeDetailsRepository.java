package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.entity.Inventory;
import com.example.myKitchenManager.entity.RecipeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RecipeDetailsRepository extends JpaRepository<RecipeDetails, Integer> {
    @Modifying
    @Transactional
    @Query(
            value  = "delete from recipe_details where recipe_details.recipe_id = ?1",
            nativeQuery = true
    )
    void deleteByRecipeId(int recipeId);
}
