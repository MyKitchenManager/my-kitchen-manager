package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.Inventory;
import com.example.myKitchenManager.entity.Users;
import com.example.myKitchenManager.repository.InventoryRepository;
import com.example.myKitchenManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    UserRepository userRepository;

    //Add method
    @PostMapping("/add")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addInventory(@RequestBody Inventory inventory, UsernamePasswordAuthenticationToken authentication){
        if (inventory.getUserId() != userRepository.findByUserName(authentication.getName()).getUserId()) {
            return ResponseEntity.badRequest().body("Cannot save to other user's inventory");
        }
        inventoryRepository.save(inventory);
        //return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.ok("Successful creation of a resource");
    }

    //Update method
    @RequestMapping(method = RequestMethod.PUT, value = "inventoryId/{inventoryId}")
    public ResponseEntity updateInventory(@RequestBody Inventory inventory, @PathVariable int inventoryId, UsernamePasswordAuthenticationToken authentication){
        if (inventory.getUserId() != userRepository.findByUserName(authentication.getName()).getUserId()) {
            return ResponseEntity.badRequest().body("Cannot update other user's inventory");
        }
        Inventory newInventory = inventoryRepository.findByInventoryId(inventoryId);
        if(newInventory != null){
            newInventory.setIngredientId(inventory.getIngredientId());
            newInventory.setPurchaseDate(inventory.getPurchaseDate());
            newInventory.setExpirationDat(inventory.getExpirationDate());
            newInventory.setInventoryVolume(inventory.getInventoryVolume());
            newInventory.setUnitsOfMeasure(inventory.getUnitsOfMeasure());
            newInventory.setUserId(inventory.getUserId());
            if(inventoryRepository.save(newInventory).getInventoryId() == inventoryId){
                return ResponseEntity.ok("Data updated successfully");
            }
        }
        return ResponseEntity.badRequest().body("Error updating data");
    }

    //Delete method
    @RequestMapping(method = RequestMethod.DELETE, value = "inventoryId/{inventoryId}")
    public ResponseEntity removeInventory(@PathVariable int inventoryId, UsernamePasswordAuthenticationToken authentication){
        Inventory inventory = inventoryRepository.findByInventoryId(inventoryId);
        if (inventory.getUserId() != userRepository.findByUserName(authentication.getName()).getUserId()) {
            return ResponseEntity.badRequest().body("Cannot delete other user's inventory");
        }
        try{
            inventoryRepository.deleteByInventoryId(inventoryId);
            return ResponseEntity.accepted().body("Inventory deleted successfully");
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    //Get inventory list for a specific user
    @RequestMapping(method = RequestMethod.GET, value = "users")
    public ResponseEntity getUserInventory(UsernamePasswordAuthenticationToken authentication) {
        int userId = userRepository.findByUserName(authentication.getName()).getUserId();
        Users user = userRepository.findByUserId(userId);
        return ResponseEntity.ok(user.getInventoryList());
    }

    /**
     * Add multiple inventory at a time
     */
    @PostMapping("/addAll")
    public ResponseEntity addAllInventory(@RequestBody List<Inventory> inventory, UsernamePasswordAuthenticationToken authentication){
        for (Inventory i : inventory) {
            inventoryRepository.save(i);
        }
        //return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.ok("Successful creation of a resource");
    }
}
