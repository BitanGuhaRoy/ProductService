package org.example.productservice.controller;

import org.example.productservice.configs.AuthenticationCommons;
import org.example.productservice.dtos.GetAllProductRequestDto;
import org.example.productservice.dtos.ProductCreatedResponseDto;
import org.example.productservice.dtos.UserDto;
import org.example.productservice.exceptions.InvalidProductException;
import org.example.productservice.exceptions.ProductDoesnotExistException;
import org.example.productservice.models.Product;
import org.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("ProductServiceSelfCall")
    private ProductService productService;
    @Autowired
    private AuthenticationCommons authenticationCommons;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws Exception
    {
//        Product product = null;
//        try {
//            product= productService.getProductById(id);
//        }
//        catch (RuntimeException e)
//        {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
//        }
        //@TODO: controller should not handle all these, controller advice comes into play, it is the final check point through which whatever controller is sending will be passed
        Product product= productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);


    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(@RequestBody GetAllProductRequestDto getAllProductRequestDto)
    {
        String token = getAllProductRequestDto.getToken();
        UserDto userDto = authenticationCommons.valiedateToken(token);
        if(userDto==null)
        {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("")
    public ProductCreatedResponseDto createProduct(@RequestBody Product product)
    {

        return productService.createProduct(product);
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id ,@RequestBody Product product)
    {
        return productService.updateProduct(id,product);
    }
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id ,@RequestBody Product product) {
        return productService.replaceProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable("id") Long id) {

        return true;
    }
}
