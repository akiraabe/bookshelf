package org.work.app.form;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Data
public class BookForm implements Serializable {

    private String title;
    private String publisher;
    private String author;
    private String publishDate;
}
