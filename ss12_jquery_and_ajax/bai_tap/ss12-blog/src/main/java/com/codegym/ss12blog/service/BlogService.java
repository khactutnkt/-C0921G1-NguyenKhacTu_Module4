package com.codegym.ss12blog.service;

import com.codegym.ss12blog.model.Blog;
import com.codegym.ss12blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return this.blogRepository.findById(id);
    }

    @Override
    public Iterable<Blog> findAllByCategoryId(Integer categoryID) {
        return this.blogRepository.findAllByCategoryId(categoryID);
    }

    @Override
    public Iterable<Blog> findByNameContaining(String name) {
        return this.blogRepository.findByNameContaining(name);
    }
}
