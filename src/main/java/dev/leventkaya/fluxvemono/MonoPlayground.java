package dev.leventkaya.fluxvemono;

import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.mongodb.DuplicateKeyException;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class MonoPlayground {
    @Test
    public void createMonoEvent() {
        Mono<String> company = Mono.just("CodeFirst").log();
        company.subscribe(data -> {
            System.out.println("Mono -> data = " + data);
        });
    }

    @Test
    public void createMonoError() {
        Mono<String> company = Mono.just("CodeFirst").log().then(Mono.error(new RuntimeException("Error occured while pushing the data")));
        company.subscribe(data -> {
            System.out.println("Mono -> data = " + data);
        });
    }

    @Test
    public void combineMonoObject() {
        Mono<String> company = Mono.just("CodeFirst");
        Mono<String> field = Mono.just("Yazilim");

        company.zipWith(field, (first ,second) -> first + second).log();
        company.subscribe(data -> {
            System.out.println("Mono -> data = " + data);
        });
    }

    @Test
    public void monoFlatMap() {
        Mono<String> company = Mono.just("CodeFirst").flatMap(data -> Mono.just(List.of(data.split("")).toString())).log();
        company.subscribe(data -> {
            System.out.println("Mono -> data = " + data);
        });
    }

    @Test
    public void monoFlatMapMany() {
        Flux<String> company = Mono.just("CodeFirst").flatMapMany(data -> Flux.just(data.split(""))).log();
        company.subscribe(data -> {
            System.out.println("Mono -> data =" + data);
        });
    }
    @Test
    public void testConc() throws InterruptedException {
        Flux<String> merhaba = Flux.fromIterable(List.of("merhaba", "levent"))
                .flatMap(data -> Flux.just(data.split("")))
                .delayElements(Duration.ofMillis(1000))
                .log();
        merhaba.subscribe(data -> {
            System.out.println("data -> " + data);
        });
    }
}
