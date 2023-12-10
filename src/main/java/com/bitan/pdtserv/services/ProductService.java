package com.bitan.pdtserv.services;

import com.bitan.pdtserv.dtos.ProductsDto;
import org.springframework.web.bind.annotation.*;

public interface ProductService {
     String getAllProducts();
     String getSingleProduct( Long productid);
     String addNewProduct();
     String updateProduct( Long productid);
     String deleteProduct(Long productid);

}
