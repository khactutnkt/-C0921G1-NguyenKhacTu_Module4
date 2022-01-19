package vn.codegym.ss7_blog.service;

import vn.codegym.ss7_blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Optional<Category> findById(Integer id);

    void remove(Category category);
}
