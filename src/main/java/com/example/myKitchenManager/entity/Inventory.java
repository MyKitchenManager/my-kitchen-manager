package com.example.myKitchenManager.entity;


import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name="inventory")
public class Inventory{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(
            name = "inventory_id"
    )
    private int inventoryId;

    @Column(
            name = "ingredient_id"
    )
    private int ingredientId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "ingredient_id",
            nullable = true,
            updatable = false,
            insertable = false
    )
    private Ingredient ingredientIdJoin;

    @Column(
            name = "purchase_date"
    )
    private Timestamp purchaseDate;
    //private Date purchaseDate;  //??????????????


    @Column(
            name = "expiration_date"
    )
    //private Date expirationDate;//??????
    private Timestamp expirationDate;

    @Column(
            name = "inventory_volume"
    )
    private int inventoryVolume;

    @Column(
            name = "units_of_measure"
    )
    private int unitsOfMeasure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "units_of_measure",
            nullable = true,
            updatable = false,
            insertable = false
    )
    private ListEntry unitsOfMeasureListEntry;

    @Column(
            name = "member_id"
    )
    private int userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "member_id",
            nullable = true,
            updatable = false,
            insertable = false
    )
    private Users userIdJoin;



    //Constructors
    public Inventory() {
    }
    public Inventory(int inventoryVolume) {
        this.inventoryVolume = inventoryVolume;
    }

    //Getter and Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Ingredient getIngredientIdJoin() {
        return ingredientIdJoin;
    }

    public void setIngredientIdJoin(Ingredient ingredientIdJoin) {
        this.ingredientIdJoin = ingredientIdJoin;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDat(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getInventoryVolume() {
        return inventoryVolume;
    }

    public void setInventoryVolume(int inventoryVolume) {
        this.inventoryVolume = inventoryVolume;
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

    public Users getUserIdJoin() {
        return userIdJoin;
    }

    public void setUserIdJoin(Users userIdJoin) {
        this.userIdJoin = userIdJoin;
    }
}