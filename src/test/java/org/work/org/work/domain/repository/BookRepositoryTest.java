package org.work.org.work.domain.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.work.domain.model.Book;
import org.work.domain.repository.BookRepository;
import org.work.util.DateUtils;

import java.lang.annotation.Annotation;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by akiraabe on 2017-06-19.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository repository;

    @Test
    public void testExample() throws Exception {
        this.entityManager.persist(new Book("Domain Deiven Design", "Pirson", "evans", DateUtils.parse("2017-06-20")));
        List<Book> books = this.repository.findAll();
        assertThat(books.size()).isEqualTo(5);
    }

}
