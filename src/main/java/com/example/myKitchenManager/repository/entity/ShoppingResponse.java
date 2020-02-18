package com.example.myKitchenManager.repository.entity;

public class ShoppingResponse {
    private Ingredient i;
    private Integer volume;

    public ShoppingResponse(Ingredient i, Integer volume) {
        this.i = i;
        this.volume = volume;
    }

    public Ingredient getI() {
        return i;
    }

    public void setI(Ingredient i) {
        this.i = i;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
