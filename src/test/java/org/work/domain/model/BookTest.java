package org.work.domain.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by akiraabe on 2017/04/29.
 */
public class BookTest {

    @Test
    public void testNormalCase() {

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Domain Driven Design");
        book.setAuthor("Eric Evans");
        book.setPublisher("ORAILEY");
        book.setPublishDate(null);

        assertThat(book.getId(), is(1L));
    }

}
