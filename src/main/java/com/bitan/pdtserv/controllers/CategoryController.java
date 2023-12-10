package com.bitan.pdtserv.controllers;

import com.bitan.pdtserv.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService= categoryService;
    }

    @GetMapping("/categories")
    public String getAllCategories()
    {
        return "return all categorie";
    }

    public  String getProductsInCategory()
    {
        return " products in category";
    }
}
