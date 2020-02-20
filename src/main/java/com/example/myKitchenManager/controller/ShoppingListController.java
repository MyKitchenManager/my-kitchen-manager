package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.*;
import com.example.myKitchenManager.repository.InventoryRepository;
import com.example.myKitchenManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shoppinglist")
public class ShoppingListController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{userId}")
    public ResponseEntity generateShoppingList(@PathVariable int userId, UsernamePasswordAuthenticationToken authentication) {
        if (userId != userRepository.findByUserName(authentication.getName()).getUserId()) {
            ResponseEntity.badRequest().body("Cannot get other user's shopping list");
        }
        Users user = userRepository.findByUserId(userId);
        List<Inventory> inventoryList = user.getInventoryList();
        List<MealPlan> mealPlanList = user.getMealPlanList();

//        List<Ingredient> test = new ArrayList<>();
//        for (Inventory i : inventoryList) {
//            test.add(i.getIngredientIdJoin());
//        }

        Map<Ingredient, Integer> inInventory = new HashMap<>();
        Map<Ingredient, Integer> needed = new HashMap<>();
        Map<Ingredient, Integer> shoppingList = new HashMap();

        for (Inventory i : inventoryList) {
            Integer volume = inInventory.get(i.getIngredientIdJoin());
            if (volume == null) {
                inInventory.put(i.getIngredientIdJoin(), i.getInventoryVolume());
            } else {
                inInventory.put(i.getIngredientIdJoin(), volume + i.getInventoryVolume());
            }
        }

        for (MealPlan m : mealPlanList) {
            for (RecipeDetails r : m.getRecipeIdJoin().getRecipeDetails()) {
                Integer volume = needed.get(r.getIngredientIdJoin());
                if (volume == null) {
                    needed.put(r.getIngredientIdJoin(), r.getIngredientVolume());
                } else {
                    needed.put(r.getIngredientIdJoin(), volume + r.getIngredientVolume());
                }
            }
        }

        for(Ingredient i : needed.keySet()) {
            Integer volume = inInventory.get(i);
            if (volume != null) {
                if (volume >= needed.get(i)) {
                    continue;
                } else {
                    shoppingList.put(i, needed.get(i) - volume);
                }
            } else {
                shoppingList.put(i, needed.get(i));
            }
        }
        List<ShoppingResponse> list = new ArrayList<>();
        for (Map.Entry<Ingredient, Integer> e : shoppingList.entrySet()) {
            ShoppingResponse sr = new ShoppingResponse(e.getKey(), e.getValue());
            list.add(sr);
        }

        List<ShoppingResponse> inventory = new ArrayList<>();
        for (Map.Entry<Ingredient, Integer> e : shoppingList.entrySet()) {
            ShoppingResponse sr = new ShoppingResponse(e.getKey(), e.getValue());
            inventory.add(sr);
        }

        List<ShoppingResponse> ingredientNeeded = new ArrayList<>();
        for (Map.Entry<Ingredient, Integer> e : shoppingList.entrySet()) {
            if (e.getValue() != 0) {
                ShoppingResponse sr = new ShoppingResponse(e.getKey(), e.getValue());
                ingredientNeeded.add(sr);
            }
        }

        List<List<ShoppingResponse>> res = new ArrayList<>();
        res.add(list);
        res.add(inventory);
        res.add(ingredientNeeded);

        return ResponseEntity.ok(res);
    }

}
