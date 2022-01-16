package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    List<Product> findByName(String name);
    void update(Integer id, Product product);
    void remove(Integer id);
    Product findById(Integer id);
}
