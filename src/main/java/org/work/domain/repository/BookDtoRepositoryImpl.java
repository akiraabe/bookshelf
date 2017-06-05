package org.work.domain.repository;

import org.springframework.stereotype.Component;
import org.work.domain.dto.BookDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by akiraabe on 2017-06-03.
 */
@Component
public class BookDtoRepositoryImpl implements BookDtoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<BookDto> findAll() {
        List<BookDto> result = em.createQuery(
                "select new org.work.domain.dto.BookDto(b.id, b.title, b.publisher , b.author, b.publishDate) from Book b",
                BookDto.class
        ).getResultList();
        return result;
    }
}
