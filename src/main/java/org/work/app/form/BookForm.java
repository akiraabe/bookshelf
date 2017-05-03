package org.work.app.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Data
public class BookForm implements Serializable {

    @NotBlank
    private String title;
    private String publisher;
    private String author;
    private Date publishDate;
}
