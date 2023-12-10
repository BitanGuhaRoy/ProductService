package com.bitan.pdtserv.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryImpl implements  CategoryService{
    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getProductsInCategory() {
        return null;
    }
}
