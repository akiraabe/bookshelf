package org.work.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by akiraabe on 2017-06-03.
 */
@Data
@ToString
public class BookDto {
    private Long id;
    private String title;
    private String publisher;
    private String author;
    private Date publishDate;

    public BookDto(Long id, String title,
                   String publisher, String author,
                   Date publishDate) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.publishDate = publishDate;
    }
}
