package vn.codegym.ss7_blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.ss7_blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService  {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Optional<Blog> findById(Integer id);

    void remove(Blog blog);

    Page<Blog> findByName(String keySearch, Pageable pageable);

    Page<Blog> findByCategoryId(Integer cateId, Pageable pageable);
}
