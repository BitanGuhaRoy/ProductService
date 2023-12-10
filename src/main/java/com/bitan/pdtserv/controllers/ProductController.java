package com.bitan.pdtserv.controllers;

import com.bitan.pdtserv.dtos.ProductsDto;
import com.bitan.pdtserv.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping()
    public String getAllProducts()
    {
        return "Getting All Products";
    }

    @GetMapping("/{productid}")
    public String getSingleProduct(@PathVariable("productid") Long productid)
    {
        return "Getting One Product with Id :"+ productid+" ";
    }

     @PostMapping ()
    public String addNewProduct(@RequestBody ProductsDto productsDto)
    {

        return "adding new product hey "+productsDto;
    }

    @PutMapping("/{productid}")
    public String updateProduct(@PathVariable("productid") Long productid, @RequestBody ProductsDto productsDto )
    {
        return "putting Product : "+productid +" "+ productsDto;
    }
    @DeleteMapping("/{productid}")
    public String deleteProduct(@PathVariable("productid") Long productid)
    {
        return "Deleting One Product : "+ productid;
    }
}
