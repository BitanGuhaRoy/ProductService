package com.bitan.pdtserv.services;

import com.bitan.pdtserv.Exception.NotFoundException;
import com.bitan.pdtserv.dtos.ProductsDto;
import com.bitan.pdtserv.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ProductService {
     List<Product> getAllProducts();
     Optional<Product> getSingleProduct(Long productid) throws NotFoundException;
//     Product getSingleProduct(Long productid);
     Product addNewProduct(ProductsDto productsDto);
     Product updateProduct( Long productid,Product product);
     Boolean deleteProduct(Long productid);



}
