package com.example.inventoryservice.controller;

import com.example.inventoryservice.repositry.InventoryRepositry;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable("skuCode") String skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
