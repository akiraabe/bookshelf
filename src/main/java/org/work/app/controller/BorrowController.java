package org.work.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.work.app.form.BookForm;
import org.work.app.form.BorrowForm;
import org.work.domain.model.Book;
import org.work.domain.model.Borrow;
import org.work.domain.model.User;
import org.work.domain.service.BookService;
import org.work.domain.service.BorrowService;
<<<<<<< HEAD
import org.work.domain.dto.BorrowDto;
=======
>>>>>>> origin/master

import java.util.Date;
import java.util.List;

/**
 * BorrowController.
 * <pre>
 *    Controller class for Borrow domain.
 * </pre>
 *
 * Created by akiraabe on 2017/04/29.
 */
@Controller
@RequestMapping("borrow")
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    @Autowired
    BookService bookService;

    @ModelAttribute
    BorrowForm setUpForm() {
        return new BorrowForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
<<<<<<< HEAD
        List<BorrowDto> borrows = borrowService.findAll();
=======
        List<Borrow> borrows = borrowService.findAll();
>>>>>>> origin/master
        if (borrows != null) borrows.forEach(System.out::println);
        model.addAttribute("borrows", borrows);
        return "borrow/list";
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    String create(@Validated BorrowForm form, BindingResult result, Model model, RedirectAttributes attributes) {

        System.out.println("*** BorrowController#execute ***");
        System.out.println(form);
        if (result.hasErrors()) {
            return "/";
        }

        User user = new User();
        user.setId(1L);
        user.setName("ケロロ軍曹");
        Book book = bookService.getOne(form.getBook().getId());
        borrowService.execute(book, user, form.getBorrowDate());

        return "redirect:";

    }

    @RequestMapping(value = "/borrow/{id}", method = RequestMethod.GET)
    public String borrow(@PathVariable Long id, Model model) {

        System.out.println("*** BorrowController#borrow ***");
        Book book = bookService.getOne(id);
        BorrowForm form = new BorrowForm();
        form.setBook(book);
        form.setBorrower("test");
        form.setBorrowDate(new Date());
        model.addAttribute("borrowForm", form);
        return "borrow/entry";
    }
}
