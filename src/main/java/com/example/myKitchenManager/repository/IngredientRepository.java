package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.repository.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByIngredientCategoryId(int categoryId);
}
