package com.example.myKitchenManager.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="meal_plan")
public class MealPlan {
    public MealPlan() {

    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="meal_plan_id")
    private int mealPlanId;


    @Column(name="member_id")
    private int userId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "member_id",
            nullable = false,
            updatable = false,
            insertable = false
    )
    private Users userIdJoin;

    @Column(name="recipe_id")
    private int recipeId;


    @ManyToOne
    @JoinColumn(
            name = "recipe_id",
            nullable = false,
            updatable = false,
            insertable = false
    )
    private Recipe recipeIdJoin;

    @Column(name="when_added")
    private Date whenAdded;

    @Column(name="meal_date")
    private Date mealDate;

    @Column(name="status")
    private String status;

    public MealPlan(MealPlanBuilder builder) {
        this.mealDate = builder.mealDate;
        this.userId = builder.userId;
        this.recipeId = builder.recipeId;
        this.status = builder.status;
        this.whenAdded = builder.whenAdded;
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Users getUserIdJoin() {
        return userIdJoin;
    }

    public void setUserIdJoin(Users userIdJoin) {
        this.userIdJoin = userIdJoin;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public Recipe getRecipeIdJoin() {
        return recipeIdJoin;
    }

    public void setRecipeIdJoin(Recipe recipeIdJoin) {
        this.recipeIdJoin = recipeIdJoin;
    }

    public Date getWhenAdded() {
        return whenAdded;
    }

    public void setWhenAdded(Date whenAdded) {
        this.whenAdded = whenAdded;
    }

    public Date getMealDate() {
        return mealDate;
    }

    public void setMealDate(Date mealDate) {
        this.mealDate = mealDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private static class MealPlanBuilder {
        private int userId;
        private int recipeId;
        private Date whenAdded;
        private Date mealDate;
        private String status;

        MealPlanBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }
        MealPlanBuilder setRecipeId(int recipeId) {
            this.recipeId = recipeId;
            return this;
        }
        MealPlanBuilder setWhenAdded(Date whenAdded) {
            this.whenAdded = whenAdded;
            return this;
        }
        MealPlanBuilder setMealDate(Date mealDate) {
            this.mealDate = mealDate;
            return this;
        }
        MealPlanBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

    }
}
