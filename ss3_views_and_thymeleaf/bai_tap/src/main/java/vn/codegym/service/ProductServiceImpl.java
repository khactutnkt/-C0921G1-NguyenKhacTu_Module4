package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.IProductRepository;
import vn.codegym.repository.ProductRepositoryImpl;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
//    @Autowired
    private IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.remove(id);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

}
