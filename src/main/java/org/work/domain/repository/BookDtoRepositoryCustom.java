package org.work.domain.repository;

import org.springframework.stereotype.Component;
import org.work.domain.dto.BookDto;

import java.util.List;

/**
 * Created by akiraabe on 2017-06-03.
 */
@Component
public interface BookDtoRepositoryCustom {
    List<BookDto> findAll();
}
