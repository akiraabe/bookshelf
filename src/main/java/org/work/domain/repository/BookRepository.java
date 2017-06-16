package org.work.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.domain.model.Book;

import java.util.List;

/**
 * Created by akiraabe on 2017/04/29.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategoryList_name(String name);

    List<Book> findByTitle(String name);
}
