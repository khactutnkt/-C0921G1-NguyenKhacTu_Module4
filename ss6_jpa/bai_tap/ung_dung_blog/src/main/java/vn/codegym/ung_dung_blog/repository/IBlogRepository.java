package vn.codegym.ung_dung_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.ung_dung_blog.model.Blog;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
