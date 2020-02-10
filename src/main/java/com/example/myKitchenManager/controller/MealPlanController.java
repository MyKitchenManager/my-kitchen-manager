package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.MealPlan;
import com.example.myKitchenManager.entity.Users;
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
import org.springframework.web.bind.annotation.*;


import javax.persistence.Basic;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mealplan")
public class MealPlanController {
    @Autowired
    MealPlanRepository mealPlanRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * Allow adding multiple meals to the meal plan
     * Take a JsonArray as input
     */
    @PostMapping("/add")
    public void addToMealPlan(@RequestBody List<MealPlan> payload) {
        for (MealPlan mealPlan : payload) {
            mealPlanRepository.save(mealPlan);
        }
    }
    /**
     * Get the list of meal plans for a specific user
     */
    @GetMapping("/{userId}")
    public List<MealPlan> getMealPlan(@PathVariable int userId) {
        Users user = userRepository.findByUserId(userId);
        return user.getMealPlanList();
    }

//    @GetMapping("/{userId}/{offset}")
//    public List<MealPlan> getMealPlan(@PathVariable int userId, @PathVariable int offset) {
//
//    }

}
