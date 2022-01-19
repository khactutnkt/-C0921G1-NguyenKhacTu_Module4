package vn.codegym.ss7_blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.ss7_blog.model.Blog;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAll(Pageable pageble);
    Page<Blog> findByNameContaining(String keySearch, Pageable pageble);
    Page<Blog> findByCategoryId(Integer cateId, Pageable pageble);
}
