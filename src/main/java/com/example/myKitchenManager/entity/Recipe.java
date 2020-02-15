package com.example.myKitchenManager.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(
            name = "recipe_id"
    )
    private int id;

    @Column(
            name = "recipe_category"
    )
    private Integer recipeCategory;

    @Column(
            name = "contributor_id"
    )
    private Integer contributorId;

    @ManyToOne(fetch = FetchType.LAZY)//(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    @JoinColumn(
            name = "contributor_id",
            nullable = true,
            updatable = false,
            insertable = false
    )
    private Users contributorIdJoin;

    @Column(
            name = "prep_time"
    )
    private int prepTime;

    @Column(
            name = "times_cooked"
    )
    private int timesCooked;

    @Column(
            name = "instructions"
    )
    private String instructions;

    @Column(
            name = "recipe_name"
    )
    private String recipeName;



    @OneToMany(mappedBy = "recipeIdJoin", cascade = CascadeType.ALL)
    private List<RecipeDetails> recipeDetails;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(Integer recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public Integer getContributorId() {
        return contributorId;
    }

    public void setContributorId(Integer contributorId) {
        this.contributorId = contributorId;
    }

    public Users getContributorIdJoin() {
        return contributorIdJoin;
    }

    public void setContributorIdJoin(Users contributorIdJoin) {
        this.contributorIdJoin = contributorIdJoin;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getTimesCooked() {
        return timesCooked;
    }

    public void setTimesCooked(int timesCooked) {
        this.timesCooked = timesCooked;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setRecipeDetails(List<RecipeDetails> recipeDetails) {
        this.recipeDetails = recipeDetails;
    }
    public List<RecipeDetails> getRecipeDetails() {
        return recipeDetails;
    }
}