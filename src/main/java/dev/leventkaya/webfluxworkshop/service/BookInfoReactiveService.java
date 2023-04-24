package dev.leventkaya.webfluxworkshop.service;

import dev.leventkaya.webfluxworkshop.domain.BookInfo;
import dev.leventkaya.webfluxworkshop.repository.BookInfoReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Configurable
@RequiredArgsConstructor
public class BookInfoReactiveService {
    @Autowired
    private BookInfoReactiveRepository bookInfoReactiveRepository;

    public Flux<BookInfo> getAllBookInfo() {
        return bookInfoReactiveRepository.findAll();
    }

    public Mono<BookInfo> postBookInfo(BookInfo bookInfo) {
        return bookInfoReactiveRepository.save(bookInfo);
    }

    public Mono<Void> deleteBookById(String id) {
        return bookInfoReactiveRepository.deleteById(id);
    }
}
