package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.repository.entity.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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
