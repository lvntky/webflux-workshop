package dev.leventkaya.webfluxworkshop.dao;

import dev.leventkaya.webfluxworkshop.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void simulateLatency(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> createCustomer() {
        return IntStream.rangeClosed(1,10)
                .peek(CustomerDao::simulateLatency)
                .peek(i -> System.out.println("Creating Customer : " + i))
                .mapToObj(i -> new Customer(i, "Customer" + i)).collect(Collectors.toList());
    }
    public Flux<Customer> createCustomerReactive() {
        return Flux.range(1,10)
                .doOnNext(i -> System.out.println("Creating Reactive Customer : " + i))
                .map(i -> new Customer(i, "ReactiveCustomer" + i))
                .delayElements(Duration.ofSeconds(1));
    }
}
