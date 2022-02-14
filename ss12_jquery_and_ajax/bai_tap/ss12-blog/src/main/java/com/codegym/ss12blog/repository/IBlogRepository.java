package com.codegym.ss12blog.repository;

import com.codegym.ss12blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Iterable<Blog> findAllByCategoryId(Integer categoryId);
    Iterable<Blog> findByNameContaining(String name);
}
