package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.Ingredient;
import com.example.myKitchenManager.entity.ListEntry;
import com.example.myKitchenManager.repository.IngredientRepository;
import com.example.myKitchenManager.repository.ListEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getNationalityList() {
        if (listEntryRepository.findBySource("Nationality") == null ||
                listEntryRepository.findBySource("Nationality").isEmpty()) {
            return ResponseEntity.badRequest().body("No resource available");
        }
        return ResponseEntity.ok(listEntryRepository.findBySource("Nationality"));
    }

    /**
     * return a list of ingredient categories for users to select
     */
    @GetMapping("/ingredientcategory")
    public ResponseEntity getIngredientCategoryList() {
        if (listEntryRepository.findBySource("Ingredient Category") == null ||
                listEntryRepository.findBySource("Ingredient Category").isEmpty()) {
            return ResponseEntity.badRequest().body("No resource available");
        }
        return ResponseEntity.ok(listEntryRepository.findBySource("Ingredient Category"));
    }

    /**
     * return a list of units of measure for users to select
     */
    @GetMapping("/unitsofmeasure")
    public ResponseEntity getUnitsOfMeasureList() {
        if (listEntryRepository.findBySource("Units of Measure") == null ||
                listEntryRepository.findBySource("Units of Measure").isEmpty()) {
            return ResponseEntity.badRequest().body("No resource available");
        }
        return ResponseEntity.ok(listEntryRepository.findBySource("Units of Measure"));
    }

    /**
     * return a list of ingredients based off the ingredient category users selected
     */
    @GetMapping("/ingredient/{categoryId}")
    public ResponseEntity getUnitsOfMeasureList(@PathVariable int categoryId) {
        if (ingredientRepository.findByIngredientCategoryId(categoryId).isEmpty()) {
            return ResponseEntity.badRequest().body("No corresponding category found");
        }
        return ResponseEntity.ok(ingredientRepository.findByIngredientCategoryId(categoryId));
    }
}
