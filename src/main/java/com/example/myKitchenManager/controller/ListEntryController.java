package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.Ingredient;
import com.example.myKitchenManager.entity.ListEntry;
import com.example.myKitchenManager.repository.IngredientRepository;
import com.example.myKitchenManager.repository.ListEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/listentry")
public class ListEntryController {

    @Autowired
    ListEntryRepository listEntryRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    /**
     * return a list of nationalities to populate the dropdown menu
     */
    @GetMapping("/nationality")
    public List<ListEntry> getNationalityList() {
        return listEntryRepository.findBySource("Nationality");
    }

    /**
     * return a list of ingredient categories for users to select
     */
    @GetMapping("/ingredientcategory")
    public List<ListEntry> getIngredientCategoryList() {
        return listEntryRepository.findBySource("Ingredient Category");
    }

    /**
     * return a list of units of measure for users to select
     */
    @GetMapping("/unitsofmeasure")
    public List<ListEntry> getUnitsOfMeasureList() {
        return listEntryRepository.findBySource("Units of Measure");
    }

    /**
     * return a list of ingredients based off the ingredient category users selected
     */
    @GetMapping("/ingredient/{categoryId}")
    public List<Ingredient> getUnitsOfMeasureList(@PathVariable int categoryId) {
        return ingredientRepository.findByIngredientCategoryId(categoryId);
    }
}
