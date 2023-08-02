package com.example.ordermicroservice.demo.repositry;

import com.example.ordermicroservice.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositry extends JpaRepository<Order, Long> {

}
