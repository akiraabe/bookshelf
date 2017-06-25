package org.work.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.work.domain.dto.BookDto;
import org.work.domain.model.Book;
import org.work.domain.repository.BookDtoRepositoryCustom;
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
    BookDtoRepositoryCustom bookDtoRepositoryCustom;

    @Autowired
    CategoryService categoryService;

    public List<BookDto> findAllDto() {
        return bookDtoRepositoryCustom.findAll();
    }

    public List<Book> findAllSortedBy(String... fields) {
        // 以下の2行はJPAのコンストラクタ式を試しているだけで実際のアプリケーションの動作上の意味はありません。
        System.out.println("*****(1) コンストラクタ式を試します。*****");
        this.findAllDto().forEach(System.out::println);

        return bookRepository.findAll(new Sort(fields));
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
            return this.findAllSortedBy("title");
        } else {
            return bookRepository.findByCategoryList_name(categoryName);
        }
    }

    public void edit(Book book) {
        this.register(book);
    }

    public void remove(Long id) {
        bookRepository.delete(id);
    }

    public List<Book> findByTitle(String name) {
        return bookRepository.findByTitle(name);
    }
}
