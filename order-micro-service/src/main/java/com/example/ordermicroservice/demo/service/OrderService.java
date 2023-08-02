package com.example.ordermicroservice.demo.service;

import com.example.ordermicroservice.demo.dto.OrderItemsDTO;
import com.example.ordermicroservice.demo.dto.OrderRequest;
import com.example.ordermicroservice.demo.model.Order;
import com.example.ordermicroservice.demo.model.OrderItems;
import com.example.ordermicroservice.demo.repositry.OrderRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepositry orderRepositry;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItemsList = orderRequest.getOrderItemsDTOList().stream().map(orderItemsDTO -> mapper(orderItemsDTO)).toList();
        order.setOrderItemsList(orderItemsList);

        orderRepositry.save(order);
    }

    private OrderItems mapper(OrderItemsDTO orderItemsDTO) {
        OrderItems orderItems = new OrderItems();
        orderItems.setPrice(orderItemsDTO.getPrice());
        orderItems.setQuantity(orderItemsDTO.getQuantity());
        orderItems.setSkuCode(orderItemsDTO.getSkuCode());
        return orderItems;
    }
}
