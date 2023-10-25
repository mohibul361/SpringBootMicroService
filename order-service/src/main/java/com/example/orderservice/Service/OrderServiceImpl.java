package com.example.orderservice.Service;

import com.example.orderservice.DTO.OrderDTO;
import com.example.orderservice.Entity.Order;
import com.example.orderservice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseEntity<String> addOrder(OrderDTO orderDTO){

        Order order = Order.builder()
                .orderName(orderDTO.getOrderName())
                .quantity(orderDTO.getQuantity())
                .price(orderDTO.getPrice())
                .build();

        orderRepository.save(order);

        return ResponseEntity.ok("Order added successfully!");
    }
    @Override
    public ResponseEntity<String> updateOrder(OrderDTO orderDTO){

        Optional<Order> order = orderRepository.findById(orderDTO.getOrderId());

        if(order.isPresent()){
            order.get().setOrderName(orderDTO.getOrderName());
            order.get().setQuantity(orderDTO.getQuantity());
            order.get().setPrice(orderDTO.getPrice());
        }
        else{
            return ResponseEntity.badRequest().body("Order is not found for this id!");
        }

        return ResponseEntity.ok("Order updated successfully!");

    }
}
