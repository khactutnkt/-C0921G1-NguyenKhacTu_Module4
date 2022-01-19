package vn.codegym.ss7_blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.ss7_blog.model.Blog;
import vn.codegym.ss7_blog.repository.IBlogRepository;

import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findByName(String keySearch, Pageable pageable) {
        return blogRepository.findByNameContaining(keySearch, pageable);
    }

    @Override
    public Page<Blog> findByCategoryId(Integer cateId, Pageable pageable) {
        return blogRepository.findByCategoryId(cateId, pageable);
    }


}
