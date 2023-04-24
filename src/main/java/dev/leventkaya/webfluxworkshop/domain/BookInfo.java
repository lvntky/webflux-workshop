package dev.leventkaya.webfluxworkshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class BookInfo {
    @Id
    private String id;
    private String name;
    private Integer year;
    private String author;
}
