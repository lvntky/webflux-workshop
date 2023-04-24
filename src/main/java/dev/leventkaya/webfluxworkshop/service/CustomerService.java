package dev.leventkaya.webfluxworkshop.service;

import dev.leventkaya.webfluxworkshop.dao.CustomerDao;
import dev.leventkaya.webfluxworkshop.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    CustomerDao dao;
    public List<Customer> loadCustomers() {
        long startTime =  System.currentTimeMillis();
        List<Customer> customer = dao.createCustomer();
        long endTime = System.currentTimeMillis();
        log.info("Total execution time: {}", (endTime - startTime));
        return customer;
    }

    public Flux<Customer> loadCustomersReactive() {
        long reactiveStartTime =  System.currentTimeMillis();
        Flux<Customer> reactiveCustomer = dao.createCustomerReactive();
        long reactiveEndTime = System.currentTimeMillis();
        log.info("Total execution time: {}", (reactiveEndTime - reactiveStartTime));
        return reactiveCustomer;
    }
}
