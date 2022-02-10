package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.ICategoryRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryRepository categoryRepository;

    @GetMapping("/")
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Integer id){
        Optional<Blog> blogOptional=blogService.findById(id);
        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategories() {
        List<Category> categories = (List<Category>) this.categoryRepository.findAll();
        if (categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<Blog>> findBlogsByCategoryID(@PathVariable Integer id) {
        List<Blog> blogs = (List<Blog>) this.blogService.findAllByCategoryId(id);

        if (blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
