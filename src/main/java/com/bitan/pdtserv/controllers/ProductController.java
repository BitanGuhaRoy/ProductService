package com.bitan.pdtserv.controllers;

import com.bitan.pdtserv.dtos.AddNewProductDto;
import com.bitan.pdtserv.dtos.GetSingleProductResponseDto;
import com.bitan.pdtserv.dtos.PostAddNewProductResponseDto;
import com.bitan.pdtserv.dtos.ProductsDto;
import com.bitan.pdtserv.models.Product;
import com.bitan.pdtserv.services.ProductService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping()
    public List<Product> getAllProducts()
    {
    return  productService.getAllProducts();
//        return "Getting All Products";
    }

    @GetMapping("/{productid}")
    public ResponseEntity<GetSingleProductResponseDto> getSingleProduct(@PathVariable("productid") Long productid)
    {
        MultiValueMap<String,String> header= new LinkedMultiValueMap<>();
        header.add("auth-token","Sorry!No access");
        GetSingleProductResponseDto getSingleProductResponseDto= new GetSingleProductResponseDto();

       Product product =  productService.getSingleProduct(productid);
        getSingleProductResponseDto.setProduct(product);
       ResponseEntity<GetSingleProductResponseDto> response =
               new ResponseEntity(getSingleProductResponseDto, header,HttpStatus.OK);

        return response;
    }

     @PostMapping ()
    public ResponseEntity<PostAddNewProductResponseDto> addNewProduct(@RequestBody ProductsDto productsDto)
    {

        Product newproduct = productService.addNewProduct(productsDto);
        PostAddNewProductResponseDto postAddNewProductResponseDto=
                new PostAddNewProductResponseDto();
        postAddNewProductResponseDto.setProduct(newproduct);
        ResponseEntity<PostAddNewProductResponseDto> response =
                new ResponseEntity<>(postAddNewProductResponseDto,HttpStatus.OK);
        return response;
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
