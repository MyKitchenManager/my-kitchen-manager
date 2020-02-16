package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.entity.Inventory;
import com.example.myKitchenManager.entity.MealPlan;
import com.example.myKitchenManager.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Integer>{
    MealPlan findByMealPlanId(int mealPlanId);

    @Modifying
    @Transactional
    @Query(
            value  = "delete from meal_plan where meal_plan.meal_plan_id = ?1",
            nativeQuery = true
    )
    void deleteByMealPlanId(int mealPlanId);
}
