package com.bitan.pdtserv.services;

import com.bitan.pdtserv.dtos.ProductsDto;
import com.bitan.pdtserv.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {
     List<Product> getAllProducts();
     Product getSingleProduct( Long productid);
     Product addNewProduct(ProductsDto productsDto);
     Product updateProduct( Long productid,Product product);
     Boolean deleteProduct(Long productid);

}
