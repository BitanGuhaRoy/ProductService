package com.bitan.pdtserv.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductImpl implements ProductService{
    @Override
    public String getAllProducts() {
        return null;
    }

    @Override
    public String getSingleProduct(Long productid) {
        return null;
    }

    @Override
    public String addNewProduct() {
        return null;
    }

    @Override
    public String updateProduct(Long productid) {
        return null;
    }

    @Override
    public String deleteProduct(Long productid) {
        return null;
    }
}
