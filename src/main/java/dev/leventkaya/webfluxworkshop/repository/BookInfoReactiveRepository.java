package dev.leventkaya.webfluxworkshop.repository;

import dev.leventkaya.webfluxworkshop.domain.BookInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookInfoReactiveRepository extends ReactiveMongoRepository<BookInfo, String> {
    Flux<BookInfo> findByYear(Integer year);
    Mono<BookInfo> findByName(String name);
}
