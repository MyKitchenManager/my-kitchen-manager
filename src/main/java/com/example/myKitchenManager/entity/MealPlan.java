package com.example.myKitchenManager.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="meal_plan")
public class MealPlan {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="meal_plan_id")
    private int mealPlanId;

    @Column(name="member_id")
    private int userId;

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
    private Date meanDate;

    @Column(name="status")
    private String status;

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

    public Date getMeanDate() {
        return meanDate;
    }

    public void setMeanDate(Date meanDate) {
        this.meanDate = meanDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
