package org.work.app.controller;

import com.sun.org.apache.regexp.internal.REUtil;
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
import org.work.domain.model.Book;
import org.work.domain.service.BookService;

import java.util.List;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @ModelAttribute
    BookForm setUpForm() {
        return new BookForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<Book> books = bookService.findAll();
        if (books != null) books.forEach(System.out::println);
        model.addAttribute("books", books);
        return "book/list";
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input() {
        return "book/input";
    }

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    String create(@Validated BookForm form, BindingResult result, Model model , RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "book/input";
        }

        Book book = new Book(form);
        bookService.register(book);

        return "redirect:";

    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model model) {

        model.addAttribute("book", bookService.getOne(id));
        return "book/show";
    }
}
