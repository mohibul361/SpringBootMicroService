package com.example.customerservice.Service;

import com.example.customerservice.DTO.CustomerDTO;
import com.example.customerservice.Entity.Customer;
import com.example.customerservice.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private WebClient webClient;
    @Override
    public ResponseEntity<String> addCustomer(CustomerDTO customerDTO){

        Customer customer = Customer.builder()
                .customerName(customerDTO.getCustomerName())
                .customerAddress(customerDTO.getCustomerAddress())
                .build();

        customerRepository.save(customer);

        return ResponseEntity.ok("Customer created successfully!");
    }
    @Override
    public Mono<Customer> getCustomerData(Long orderId) {
        String url = UriComponentsBuilder.fromPath("/customer/{customerId}/order")
                .buildAndExpand(orderId)
                .toUriString();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Customer.class);
    }


}
