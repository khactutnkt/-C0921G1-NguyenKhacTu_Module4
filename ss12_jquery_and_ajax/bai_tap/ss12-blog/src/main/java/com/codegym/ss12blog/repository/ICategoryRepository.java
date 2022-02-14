package com.codegym.ss12blog.repository;

import com.codegym.ss12blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
