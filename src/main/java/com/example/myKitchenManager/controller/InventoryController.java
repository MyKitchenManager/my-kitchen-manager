package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.Inventory;
import com.example.myKitchenManager.repository.InventoryRepository;
//import com.mysql.cj.Session;
//import com.mysql.cj.xdevapi.Session;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.myKitchenManager.util.Util;

import java.io.Serializable;
import java.util.List;

@RestControllerAdvice
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    //Add method
   // @PostMapping("/add")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addInventory(@RequestBody Inventory inventory){
        inventoryRepository.save(inventory);
        //return new ResponseEntity<>(HttpStatus.OK);
        return Util.createResponseEntity("Successful creation of a resource", HttpStatus.CREATED);
    }

    //Update method
    @RequestMapping(method = RequestMethod.PUT, value = "inventoryId/{inventoryId}")
    public ResponseEntity updateInventory(@RequestBody Inventory inventory, @PathVariable int inventoryId){
        Inventory newInventory = inventoryRepository.findByInventoryId(inventoryId);
        if(newInventory != null){
            newInventory.setIngredientId(inventory.getIngredientId());
            newInventory.setPurchaseDate(inventory.getPurchaseDate());
            newInventory.setExpirationDat(inventory.getExpirationDate());
            newInventory.setInventoryVolume(inventory.getInventoryVolume());
            newInventory.setUnitsOfMeasure(inventory.getUnitsOfMeasure());
            newInventory.setUserId(inventory.getUserId());
            if(inventoryRepository.save(newInventory).getInventoryId() == inventoryId){
                return Util.createResponseEntity("Data updated successfully", HttpStatus.OK);
            }
        }
        return Util.createResponseEntity("Error updating data", HttpStatus.NOT_FOUND);
    }

    //Delete method
    @RequestMapping(method = RequestMethod.DELETE, value = "inventoryId/{inventoryId}")
    public ResponseEntity<?> removeInventory(@PathVariable int inventoryId){
        try{
     //       inventoryRepository.deleteByInventoryId(inventoryId);
            Inventory newInventory = inventoryRepository.findByInventoryId(inventoryId);
            inventoryRepository.delete(newInventory);
            return Util.createResponseEntity("Data deleted successfully", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return Util.createResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
        }
    }

//    private  boolean deleteByInventoryId(Class<?> type, Serializable id) {
//        Object persistentInstance = Session.load(type, id);
//        //Object persistentInstance = Session.load(
//        if (persistentInstance != null) {
//        Session.delete(persistentInstance);
//        return true;
//        }
//        return false;
//    }
    //Testing
    @GetMapping("getInventory")
    public List<Inventory> allInventory(){
        return inventoryRepository.findAll();
    }
}
