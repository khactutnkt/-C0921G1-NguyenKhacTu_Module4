package com.codegym.ss12blog.controller;

import com.codegym.ss12blog.model.Blog;
import com.codegym.ss12blog.model.Category;
import com.codegym.ss12blog.repository.ICategoryRepository;
import com.codegym.ss12blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryRepository categoryRepository;

//    @GetMapping()
//    public ResponseEntity<Iterable<Blog>> findAllBlog() {
//        List<Blog> blogs = (List<Blog>) blogService.findAll();
//        if (blogs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }


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

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> findByName(@RequestParam String name){
        List<Blog> blogs = (List<Blog>) this.blogService.findByNameContaining(name);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping()
    public ModelAndView getAllBlogs() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs",this.blogService.findAll());
        modelAndView.addObject("categories",this.categoryRepository.findAll());
        return modelAndView;
    }
}
