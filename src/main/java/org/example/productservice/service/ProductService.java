package org.example.productservice.service;

import org.example.productservice.dtos.ProductCreatedResponseDto;
import org.example.productservice.exceptions.InvalidProductException;
import org.example.productservice.exceptions.ProductDoesnotExistException;
import org.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
     Product getProductById(Long id) throws  Exception;
     ProductCreatedResponseDto createProduct(Product product);
     Product updateProduct(Long id, Product product);
     Product replaceProduct(Long id, Product product);
     Boolean deleteProduct(Long id);
     public List<Product> getAllProducts();

}
