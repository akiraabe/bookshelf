package org.work.domain.model;

import lombok.Data;
import lombok.ToString;
import org.work.app.form.BookForm;
import org.work.util.DateUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Data
@ToString
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String publisher;

    private String author;

    @Temporal(value = TemporalType.DATE)
    private Date publishDate;

    public Book(BookForm form) {
        this.title = form.getTitle();
        this.publisher = form.getPublisher();
        this.author = form.getAuthor();
        this.publishDate = form.getPublishDate();
    }
    public Book() {
    }
}
