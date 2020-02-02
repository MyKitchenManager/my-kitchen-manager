package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.entity.Inventory;
import com.example.myKitchenManager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
//    Users findByEmailAddress(String emailAddress);
//    Users findByUserId(int userId);
//    Users findByUserName(String userName);
    Inventory findByInventoryVolume(int inventoryVolume);

}