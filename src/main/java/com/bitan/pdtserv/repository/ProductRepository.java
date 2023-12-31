package com.bitan.pdtserv.repository;

import com.bitan.pdtserv.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

Product save(Product product);
Product findProductById(Long id);
//void deleteProductBy(Long id);
}
