package com.example.customerservice.Service;

import com.example.customerservice.DTO.CustomerDTO;
import com.example.customerservice.Entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public interface CustomerService {

    ResponseEntity<String> addCustomer(CustomerDTO customerDTO);

    public Mono<Customer> getCustomerData(Long orderId);
}
