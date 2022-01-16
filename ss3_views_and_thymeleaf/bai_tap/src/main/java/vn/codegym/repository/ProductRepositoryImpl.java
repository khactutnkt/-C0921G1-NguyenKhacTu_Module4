package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepositoryImpl implements IProductRepository{
    private static Map<Integer,Product> productMap;
    static {
        productMap = new TreeMap<>();
        productMap.put(1, new Product(1,"Iphone 11", 1500.0, 100, "USA"));
        productMap.put(2, new Product(2,"Iphone 13", 2200.0, 110, "USA"));
        productMap.put(3, new Product(3,"Sony XZ3", 1700.0, 50, "Korea"));
        productMap.put(4, new Product(4,"Samsung node 10", 1000.0, 100, "Korea"));
        productMap.put(5, new Product(5,"Xiaomi mi 10", 1200.0, 80, "China"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getName().toLowerCase().indexOf(name.toLowerCase()) != -1){
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public void update(Integer id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }
}
