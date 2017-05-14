package org.work.domain.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.work.app.form.BookForm;
import org.work.util.DateUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @NotBlank
    private String title;

    private String publisher;

    private String author;

    @Temporal(value = TemporalType.DATE)
    private Date publishDate;

    @OneToMany
    private List<Category> categoryList;

    @Transient
    private String categories;

    public Book(BookForm form) {
        this.title = form.getTitle();
        this.publisher = form.getPublisher();
        this.author = form.getAuthor();
        this.publishDate = form.getPublishDate();
        this.categories = form.getCategories();
    }

    public Book() {
    }

    public Book(String title, String publisher, String author, Date publishDate) {
        System.out.println("Book#constructor");
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.publishDate = publishDate;
    }
}
