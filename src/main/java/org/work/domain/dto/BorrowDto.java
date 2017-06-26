package org.work.domain.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by akiraabe on 2017-06-17.
 */
@Data
@ToString
public class BorrowDto {

    private Long id;
    private Date borrowDate;
    private Long bookId;
    private String bookTitle;
    private Long userId;
    private String userName;
}
