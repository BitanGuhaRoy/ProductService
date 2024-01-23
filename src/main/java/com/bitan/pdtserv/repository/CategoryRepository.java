package com.bitan.pdtserv.repository;

import com.bitan.pdtserv.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category save(Category category);
    Category findCategoryById(Long id);

//    void deleteById(Long aLong);
    List<Category> findAllByIdIn(List<Long> ids);


}
