package org.work.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.work.domain.model.Category;
import org.work.domain.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Service
@Transactional
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category getOne(Long id) {
        return categoryRepository.getOne(id);
    }

    public void register(Category category) {
        categoryRepository.save(category);
    }

    /**
     *
     * @param categories
     * @return
     */
    public List<Category> prepare(String categories) {

        List<Category> categoryList = new ArrayList<>();
        for (String category : categories.split(",")) {
            Category catFromRepo = categoryRepository.findByName(category.toLowerCase().trim());
            System.out.println("catFromRepo : " + catFromRepo);
            if (catFromRepo == null) {
                catFromRepo = new Category(category.toLowerCase().trim());
                categoryRepository.save(catFromRepo);
            }
            categoryList.add(catFromRepo);
        }
        return categoryList;
    }
}
