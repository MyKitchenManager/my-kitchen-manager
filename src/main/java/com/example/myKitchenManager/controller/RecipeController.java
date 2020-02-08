package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.Inventory;
import com.example.myKitchenManager.entity.Recipe;
import com.example.myKitchenManager.entity.Users;
import com.example.myKitchenManager.repository.InventoryRepository;
//import com.mysql.cj.Session;
//import com.mysql.cj.xdevapi.Session;
import com.example.myKitchenManager.repository.RecipeRepository;
import com.example.myKitchenManager.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.myKitchenManager.util.Util;

import java.io.Serializable;
import java.util.List;

@RestControllerAdvice
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/all")
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
