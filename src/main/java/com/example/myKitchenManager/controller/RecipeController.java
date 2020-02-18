package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.repository.entity.Recipe;
import com.example.myKitchenManager.repository.entity.RecipeDetails;
import com.example.myKitchenManager.repository.entity.Users;
import com.example.myKitchenManager.repository.RecipeDetailsRepository;
import com.example.myKitchenManager.repository.RecipeRepository;
import com.example.myKitchenManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeDetailsRepository recipeDetailsRepository;

    /**
     * Get the list of Recipe
     */
    @GetMapping("/all")
    public ResponseEntity getAllRecipes() {
        return ResponseEntity.ok(recipeRepository.findAll());
    }
    /**
     * Get the list of Recipe  for a specific users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity getRecipesByUserId(UsernamePasswordAuthenticationToken authentication){
        int userId = userRepository.findByUserName(authentication.getName()).getUserId();
        Users user = userRepository.findByUserId(userId);
        return ResponseEntity.ok(user.getRecipeList());
    }
    /**
     * Get the list of Recipe details for a specific recipe
     */
    @RequestMapping(method = RequestMethod.GET, value = "/details/recipeId/{recipeId}")
    public ResponseEntity getRecipeDetails(@PathVariable int recipeId, UsernamePasswordAuthenticationToken authentication){
        Integer contributorId = recipeRepository.findById(recipeId).getContributorId();
//        if(contributorId == null)  {
//            return ResponseEntity.badRequest().body("Contributor Id can Not be null");
//        }
//        if(contributorId == null) { //11 i Menglin Yu
//            contributorId = 11;
//        }
//        if (contributorId!= userRepository.findByUserName(authentication.getName()).getUserId()) {
//            return ResponseEntity.badRequest().body("Cannot get to other user's data");
//        }
        //return recipeDetailsRepository.findByRecipeId(recipeId);
        return ResponseEntity.ok(recipeRepository.findById(recipeId).getRecipeDetails());
    }

    /**
     * Allow adding recipe and details to DB
     * Take a JsonArray as input
     */
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity addRecipes(@RequestBody Recipe recipe, UsernamePasswordAuthenticationToken authentication){
        Integer contributorId = recipe.getContributorId();
        if(contributorId == null)  {
            return ResponseEntity.badRequest().body("Contributor Id can Not be null");
        }
        if (contributorId != userRepository.findByUserName(authentication.getName()).getUserId()) {
            return ResponseEntity.badRequest().body("Cannot add to other user's data");
        }
        List<RecipeDetails> details = recipe.getRecipeDetails();
        recipe.setRecipeDetails(null);
        recipeRepository.save(recipe);//only save part of recipe
        int recipeId = recipe.getId();
        //save details list with this recipeId
        for(int i = 0; i <details.size() ; i++){
            RecipeDetails detailsItem = details.get(i);
            detailsItem.setRecipeId(recipeId);
            recipeDetailsRepository.save(detailsItem);
        }
        return ResponseEntity.ok("Successful creation of a resource" );
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity deleteRecipes(@PathVariable int recipeId) {
        recipeDetailsRepository.deleteByRecipeId(recipeId);
        recipeRepository.deleteByRecipeId(recipeId);
        return ResponseEntity.ok("Successfully deleted recipe");
    }

    //Testing Add method
    @RequestMapping(method = RequestMethod.POST, value = "/details/add")
    public ResponseEntity addRecipesDetails(@RequestBody RecipeDetails recipeDetails){
        return ResponseEntity.ok(recipeDetailsRepository.save(recipeDetails));
    }

    //Update Recipe Method
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity updateRecipes(@RequestBody Recipe recipe, @PathVariable int id, UsernamePasswordAuthenticationToken authentication){
        if (recipe.getContributorId() == null || recipe.getContributorId() != userRepository.findByUserName(authentication.getName()).getUserId()) {
            return ResponseEntity.badRequest().body("Cannot update other user's data");
        }
        List<RecipeDetails> details = recipe.getRecipeDetails();
        recipe.setRecipeDetails(null);
        recipe.setId(id);
        recipeRepository.save(recipe);
        recipeDetailsRepository.deleteByRecipeId(id);
        for(int i = 0; i <details.size() ; i++){
            RecipeDetails detailsItem = details.get(i);
            detailsItem.setRecipeId(id);
            recipeDetailsRepository.save(detailsItem);
        }
        return ResponseEntity.ok("Successfully updated recipe details");
    }
}
