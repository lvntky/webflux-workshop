package dev.leventkaya.webfluxworkshop.controller;

import dev.leventkaya.webfluxworkshop.domain.BookInfo;
import dev.leventkaya.webfluxworkshop.service.BookInfoReactiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RequiredArgsConstructor
@RestController
@Configurable
@RequestMapping("/api/v1")
public class BookInfoReativeController {
    @Autowired
    private BookInfoReactiveService bookInfoReactiveService;
    @GetMapping("/getAllBookInfo")
    public Flux<BookInfo> getAllBookInfo() {
        return bookInfoReactiveService.getAllBookInfo();
    }
    @PostMapping("/addBook")
    public Mono<BookInfo> addBook(@RequestBody BookInfo bookInfo) {
        return bookInfoReactiveService.postBookInfo(bookInfo);
    }

    @DeleteMapping("/deleteBook/{id}")
    public Mono<Void> deleteBook(@PathVariable String id) {
        return bookInfoReactiveService.deleteBookById(id);
    }
}
