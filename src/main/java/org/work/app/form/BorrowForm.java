package org.work.app.form;

import lombok.Data;
import lombok.ToString;
import org.work.domain.model.Book;

import java.util.Date;

/**
 * Created by akiraabe on 2017-06-26.
 */
@Data
@ToString
public class BorrowForm {

    private Book book;
    private String borrower;
    private Date borrowDate;

}
