package vn.codegym.ss7_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.ss7_blog.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
