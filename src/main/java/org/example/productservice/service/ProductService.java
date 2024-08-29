package org.example.productservice.service;

import org.example.productservice.models.Product;

public interface ProductService {
     Product getProductById(Long id);
     Product createProduct(Product product);
     Product updateProduct(Long id, Product product);
     Product replaceProduct(Long id, Product product);
     Boolean deleteProduct(Long id);

}
