package dev.leventkaya.webfluxworkshop.controller;

import dev.leventkaya.webfluxworkshop.dto.Customer;
import dev.leventkaya.webfluxworkshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    CustomerService service;

    // BLOCKING
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return service.loadCustomers();
    }

    // REACTIVE
    @GetMapping(value = "/getAllCustomers/reactive",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersReactive() {
        return service.loadCustomersReactive();
    }
}
