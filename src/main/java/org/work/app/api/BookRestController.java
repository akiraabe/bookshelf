package org.work.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.work.app.form.BookForm;
import org.work.domain.model.Book;
import org.work.domain.service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BookController.
 * <pre>
 *     Controller class for Book domain.
 * </pre>
 * <p>
 * Created by akiraabe on 2017/07/01.
 */
@RestController
@RequestMapping("api")
public class BookRestController {

    @Autowired
    BookService bookService;

    @ModelAttribute
    BookForm setUpForm() {
        return new BookForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> list(Model model) {
        return bookService.findAllSortedBy("title");
//        if (books != null) books.forEach(System.out::println);
//        model.addAttribute("books", books);
//        return "book/list";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Map<String, String> show(@PathVariable Long id, Model model) {
        //TODO: JacksonがLazyLoadのプロパティに対応していない模様なのでMapで返却（やっつけ仕事）
        Book book = bookService.getOne(id);
        Map<String, String> result = new HashMap<>();
        result.put("id", book.getId().toString());
        result.put("title", book.getTitle());
        result.put("author", book.getAuthor());
        // サーバの処理遅延をエミュレート
        try {
            Thread.sleep(5000); //5000ミリ秒Sleepする
        } catch (InterruptedException e) {
        }
        return result;
    }
}
