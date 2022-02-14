package com.codegym.ss12blog.service;

import com.codegym.ss12blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Integer id);

    Iterable<Blog> findAllByCategoryId(Integer categoryID);

    Iterable<Blog> findByNameContaining(String name);
}
