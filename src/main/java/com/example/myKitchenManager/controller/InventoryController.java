package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.Inventory;
import com.example.myKitchenManager.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.myKitchenManager.security.Util;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    //Add method
    @PostMapping("/add")
    public ResponseEntity addInventory(@RequestBody Inventory inventory){
        inventoryRepository.save(inventory);
        //return new ResponseEntity<>(HttpStatus.OK);
        return Util.createResponseEntity("Successful creation of a resource", HttpStatus.CREATED);
    }

//    //Update method
//    @PutMapping("/update")
//    public ResponseEntity updateInventory(@RequestBody Inventory inventory, @PathVariable int inventoryId){
//
//    }
//
    //Delete method
    @DeleteMapping("/delete")
    //@RequestMapping(method = RequestMethod.DELETE, value = "inventoryId/{inventoryId}")
    public ResponseEntity<?> removeInventory(@PathVariable int inventoryId){
        try{
            inventoryRepository.deleteById(inventoryId);
            return Util.createResponseEntity("Data deleted successfully", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return Util.createResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
        }
    }
    //Testing
    @GetMapping("getInventory")
    public List<Inventory> allInventory(){
        return inventoryRepository.findAll();
    }
}
