package com.example.orderservice.Service;

import com.example.orderservice.DTO.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {

    public ResponseEntity<String> addOrder(OrderDTO orderDTO);

    public ResponseEntity<String> updateOrder(OrderDTO orderDTO);
}
