package vn.codegym.ung_dung_blog.service;

import vn.codegym.ung_dung_blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService  {
    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findById(Integer id);

    void remove(Blog blog);
}
