package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmailAddress(String emailAddress);
    Users findByUserId(int userId);
    Users findByUserName(String userName);

}