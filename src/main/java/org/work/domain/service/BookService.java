package org.work.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.work.domain.model.Book;
import org.work.domain.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryService categoryService;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book getOne(Long id) {
        return bookRepository.getOne(id);
    }

    public void register(Book book) {
        book.setCategoryList(categoryService.prepare(book.getCategories()));
        bookRepository.save(book);
    }

    public List<Book> findByCategoryList_name(String categoryName) {
        if (categoryName.isEmpty()) {
            return this.findAll();
        } else {
            return bookRepository.findByCategoryList_name(categoryName);
        }
    }
}
