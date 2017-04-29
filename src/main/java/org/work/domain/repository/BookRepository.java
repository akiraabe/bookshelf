package org.work.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.domain.model.Book;

/**
 * Created by akiraabe on 2017/04/29.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
