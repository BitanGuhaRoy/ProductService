package org.example.productservice.controller;

import org.example.productservice.models.Product;
import org.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("ProductServiceFakeStoreCall")
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
       return productService.getProductById(id);
//        return new Product();
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return product;
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id ,@RequestBody Product product) {
        return product;
    }
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id ,@RequestBody Product product) {
        return product;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable("id") Long id) {
        return true;
    }
}
