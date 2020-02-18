package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.*;
import com.example.myKitchenManager.repository.InventoryRepository;
import com.example.myKitchenManager.repository.MealPlanRepository;
import com.example.myKitchenManager.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
//import sun.plugin2.message.WindowActivationEventMessage;


import javax.persistence.Basic;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mealplan")
public class MealPlanController {
    @Autowired
    MealPlanRepository mealPlanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    /**
     * Allow adding multiple meals to the meal plan
     * Take a JsonArray as input
     */
    @PostMapping("/add")
    public ResponseEntity addToMealPlan(@RequestBody List<MealPlan> payload, UsernamePasswordAuthenticationToken authentication) {
        if (payload == null || payload.isEmpty()) {
            return ResponseEntity.badRequest().body("Empty input");
        }
        int userId = userRepository.findByUserName(authentication.getName()).getUserId();
        if (payload.get(0).getUserId() != userId) {
            return ResponseEntity.badRequest().body("Cannot add to other user's mealplan");
        }
        for (MealPlan mealPlan : payload) {
            mealPlanRepository.save(mealPlan);
        }
        return ResponseEntity.ok("Successfully added to meal plan");
    }
    /**
     * Get the list of meal plans for a specific user
     * Need to check if the status is inactive
     */
    @GetMapping("/users")
    public ResponseEntity getMealPlan(UsernamePasswordAuthenticationToken authentication) {
        int userId = userRepository.findByUserName(authentication.getName()).getUserId();
        Users user = userRepository.findByUserId(userId);
        List<MealPlan> mealPlanList = user.getMealPlanList();

        Iterator<MealPlan> itr = mealPlanList.iterator();
        while(itr.hasNext()) {
            String status = itr.next().getStatus();
            if (status != null && status.equals("inactive")) {
                itr.remove();
            }
        }
        return ResponseEntity.ok(mealPlanList);
        //return ResponseEntity.ok(user.getMealPlanList());
    }
    /**
     * Finish Cook method
     * 1.update the status of the mealPlan to be inactive
     * 2.update the inventory of the user.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/finishCook/mealPlanId/{mealPlanId}")
    public ResponseEntity finishCook(@PathVariable int mealPlanId, UsernamePasswordAuthenticationToken authentication){
        // update the status of mealPlan
        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
        mealPlan.setStatus("inactive");
        mealPlanRepository.save(mealPlan);

        // update the inventory according to  the recipe
        Users user = userRepository.findByUserName(authentication.getName());
        List<Inventory> inventoryList = user.getInventoryList();

        Map<Ingredient, Integer> needed = new HashMap<>();
        for (RecipeDetails r : mealPlan.getRecipeIdJoin().getRecipeDetails()) {
            Integer volume = needed.get(r.getIngredientIdJoin());
            if (volume == null) {
                needed.put(r.getIngredientIdJoin(), r.getIngredientVolume());
            } else {
                needed.put(r.getIngredientIdJoin(), volume + r.getIngredientVolume());
            }
        }
        //Improvement 1 :sort the inventoryList by purchase date
        //???
        //Improvement 2 : update each inventory according to needed map/
        //!!!Iterate over Ingredients instead of Inventory
        for(Inventory i : inventoryList){
            Integer volume = needed.get(i.getIngredientIdJoin());
            if(volume != null){//update inventory  table
                if(i.getInventoryVolume() > volume){
                    i.setInventoryVolume(i.getInventoryVolume() - volume);
                    needed.put(i.getIngredientIdJoin(), null);
                    inventoryRepository.save(i);
                }else{
                    needed.put(i.getIngredientIdJoin(), volume - i.getInventoryVolume());
                    inventoryRepository.deleteByInventoryId(i.getInventoryId());

                }
                //inventoryRepository.save(i); //????
            }
            //else do nothing
        }
        return ResponseEntity.ok("Successfully finished Cook! ");
    }

//    @GetMapping("/{userId}/{offset}")
//    public List<MealPlan> getMealPlan(@PathVariable int userId, @PathVariable int offset) {
//
//    }

}
