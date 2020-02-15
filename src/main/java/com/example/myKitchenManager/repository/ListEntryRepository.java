package com.example.myKitchenManager.repository;

import com.example.myKitchenManager.entity.ListEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListEntryRepository extends JpaRepository<ListEntry, Integer> {
    List<ListEntry> findBySource(String source);
}
