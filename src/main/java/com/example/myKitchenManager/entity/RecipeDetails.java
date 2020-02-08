package com.example.myKitchenManager.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "recipe_details")
public class RecipeDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(
            name = "recipe_details_id"
    )
    private int id;

    @Column(
            name = "recipe_id"
    )
    private int recipeId;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)//(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    @JoinColumn(
            name = "recipe_id",
            nullable = false,
            updatable = false,
            insertable = false
    )
    private Recipe recipeIdJoin;

    @Column(
            name = "ingredient_id"
    )
    private int ingredientId;

    @Column(
            name = "ingredient_volume"
    )
    private int ingredientVolume;

    @Column(
            name = "units_of_measure"
    )
    private int unitsOfMeasure;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@ManyToOne(cascade = CascadeType.REMOVE)
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    @JoinColumn(
            //name = "list_entry_id",//!!!!
            name = "units_of_measure",
            nullable = false,
            updatable = false,
            insertable = false
    )
    private ListEntry unitsOfMeasureListEntry;

    public RecipeDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getUnitsOfMeasure() {
        return unitsOfMeasure;
    }

    public void setUnitsOfMeasure(int unitsOfMeasure) {
        this.unitsOfMeasure = unitsOfMeasure;
    }

    public ListEntry getUnitsOfMeasureListEntry() {
        return unitsOfMeasureListEntry;
    }

    public void setUnitsOfMeasureListEntry(ListEntry unitsOfMeasureListEntry) {
        this.unitsOfMeasureListEntry = unitsOfMeasureListEntry;
    }
    public Recipe getRecipeIdJoin() {
        return recipeIdJoin;
    }

    public int getIngredientVolume() {
        return ingredientVolume;
    }

    public void setIngredientVolume(int ingredientVolume) {
        this.ingredientVolume = ingredientVolume;
    }
}
