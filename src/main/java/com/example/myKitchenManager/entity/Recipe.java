package com.example.myKitchenManager.entity;

        import javax.persistence.*;
        import java.sql.Timestamp;

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
    private int recipeCategory;



    @Column(
            name = "contributor_id"
    )
    private int contributorId;

    @Column(
            name = "recipe_category"
    )
    private int recipeCategory;

    @Column(
            name = "prep_time"
    )
    private Timestamp prepTime;

    @Column(
            name = "times_cooked"
    )
    private Timestamp timesCooked;

}
