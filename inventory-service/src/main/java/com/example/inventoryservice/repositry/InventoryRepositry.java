package com.example.inventoryservice.repositry;

import com.example.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepositry extends JpaRepository<Inventory , Long> {
    Optional<Inventory> findBySkuCode();
}
