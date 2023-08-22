package com.example.ordermicroservice.repositry;

import com.example.ordermicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositry extends JpaRepository<Order, Long> {

}
