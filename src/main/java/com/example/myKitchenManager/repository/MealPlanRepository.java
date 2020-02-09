package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.entity.MealPlan;
import com.example.myKitchenManager.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Integer>{
}
