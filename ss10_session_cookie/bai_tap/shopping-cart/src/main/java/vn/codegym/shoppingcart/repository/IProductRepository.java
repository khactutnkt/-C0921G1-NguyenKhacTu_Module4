package vn.codegym.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.shoppingcart.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
