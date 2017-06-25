package org.work.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.work.domain.model.Book;
import org.work.domain.model.Borrow;
import org.work.domain.model.User;
import org.work.domain.repository.BorrowRepository;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by akiraabe on 2017/06/17.
 */
@Service
@Transactional
public class BorrowService {

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    public void execute(Book book , User user, Date dateOfBorrowing) {

        System.out.println("BorrowService#execute");
        if (dateOfBorrowing == null) {
           dateOfBorrowing = new Date();
        }

        System.out.println(book.getTitle());
        System.out.println(user);
        System.out.println(dateOfBorrowing);

        Borrow borrow = new Borrow();
        borrow.setBookId(book.getId());
        borrow.setUserId(user.getId());
        borrow.setBorrowDate(dateOfBorrowing);
        borrowRepository.save(borrow);
    }
}

