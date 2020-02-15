package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.entity.RecipeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDetailsRepository extends JpaRepository<RecipeDetails, Integer> {
}
