package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.repository.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
//    Users findByEmailAddress(String emailAddress);
//    Users findByUserId(int userId);
//    Users findByUserName(String userName);
    Inventory findByInventoryId(int inventoryId);
    String table_name = System.getenv("DB_SCHEMA");
    @Modifying
    @Transactional
    @Query(
            value  = "delete from inventory where inventory.inventory_id = ?1",
            nativeQuery = true
    )
    void deleteByInventoryId(int inventoryId);
    Inventory findByIngredientIdAndUserId(int ingredientId, int userId);
}