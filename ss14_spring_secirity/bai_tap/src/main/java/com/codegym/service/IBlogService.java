package com.codegym.service;

import com.codegym.model.Blog;

public interface IBlogService {
    Iterable<Blog> findAll();
    void save(Blog blog);
}
