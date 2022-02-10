package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Integer id);

    Iterable<Blog> findAllByCategoryId(Integer categoryID);
}
