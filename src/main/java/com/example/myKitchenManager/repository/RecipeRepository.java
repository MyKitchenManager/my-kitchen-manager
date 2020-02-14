package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.entity.Recipe;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Recipe findById(int id);
}