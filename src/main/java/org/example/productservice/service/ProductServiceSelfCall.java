package org.example.productservice.service;

import org.example.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("ProductServiceSelfCall")
public class ProductServiceSelfCall implements ProductService{
    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(Long id) {
        return null;
    }
}
