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

        return ResponseEntity.ok(user.getMealPlanList());
    }

//    @GetMapping("/{userId}/{offset}")
//    public List<MealPlan> getMealPlan(@PathVariable int userId, @PathVariable int offset) {
//
//    }

}
