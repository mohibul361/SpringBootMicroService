package com.example.customerservice.Controller;

import com.example.customerservice.DTO.CustomerDTO;
import com.example.customerservice.Entity.Customer;
import com.example.customerservice.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }
    @GetMapping("/{orderId}")
    public Mono<Customer> getCustomerForOrder(@PathVariable Long orderId){
        return customerService.getCustomerData(orderId);
    }
}
