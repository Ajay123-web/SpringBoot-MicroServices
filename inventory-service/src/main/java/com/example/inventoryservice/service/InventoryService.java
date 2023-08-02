package com.example.inventoryservice.service;

import com.example.inventoryservice.repositry.InventoryRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepositry inventoryRepositry;

    @Transactional(readOnly = true)
    public Boolean isInStock(String skuCode) {
        return inventoryRepositry.findBySkuCode().isPresent();
    }
}
