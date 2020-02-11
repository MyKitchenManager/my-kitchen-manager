package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.Recipe;
import com.example.myKitchenManager.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
