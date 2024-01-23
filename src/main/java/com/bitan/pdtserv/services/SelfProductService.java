package com.bitan.pdtserv.services;

import com.bitan.pdtserv.dtos.ProductsDto;
import com.bitan.pdtserv.models.Product;
import com.bitan.pdtserv.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class SelfProductService implements ProductService {


    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productid) {
        return null;
    }

    @Override
    public Product addNewProduct(ProductsDto productsDto) {
        return null;
    }

    @Override
    public Product updateProduct(Long productid,Product product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productid) {
        return null;
    }
}
