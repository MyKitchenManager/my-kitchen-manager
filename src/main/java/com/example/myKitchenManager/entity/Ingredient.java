package com.example.myKitchenManager.entity;

import javax.persistence.*;


@Entity
@Table(
        name = "ingredient"
)
public class Ingredient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(
            name = "ingredient_id"
    )
    private int ingredientId; //primary key using @Id     //The value can be AUTO, TABLE, SEQUENCE, or IDENTITY.

    @Column(
            name = "ingredient_category"
    )
    private int ingredientCategoryId;

    @Column(
            name = "ingredient_name",
            length = 50)
    private String ingredientName;

    @Column(
            name = "ingredient_image_url"
    )
    private String imageUrl;

    public Ingredient() {
    }

    public Ingredient(int ingredientId, int ingredientCategoryId, String ingredientName, String imageUrl ){
        this.ingredientId = ingredientId;
        this.ingredientCategoryId = ingredientCategoryId;
        this.ingredientName = ingredientName;
        this.imageUrl = imageUrl;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getIngredientCategoryId() {
        return ingredientCategoryId;
    }

    public void setIngredientCategoryId(int ingredientCategoryId) {
        this.ingredientCategoryId = ingredientCategoryId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}