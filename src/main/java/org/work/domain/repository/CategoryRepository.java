package org.work.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.domain.model.Category;

/**
 * Created by akiraabe on 2017/05/13.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String cat);
}
