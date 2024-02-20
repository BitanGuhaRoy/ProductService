package com.bitan.pdtserv.controllers;

import com.bitan.pdtserv.Exception.NotFoundException;
import com.bitan.pdtserv.dtos.*;
import com.bitan.pdtserv.models.Category;
import com.bitan.pdtserv.models.Product;
import com.bitan.pdtserv.repository.CategoryRepository;
import com.bitan.pdtserv.services.CategoryService;
import com.bitan.pdtserv.services.ProductService;
import com.bitan.pdtserv.services.SelfProductService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("selfProductService")
    // @Qualifier("selfProductService")
    // selfProductService is giving stackoverflow.
    private ProductService productService;
    private CategoryService categoryService;

    @GetMapping()
    public List<Product> getAllProducts()
    {
//        return selfProductService.getAllProducts();
    return  productService.getAllProducts();
//        return "Getting All Products";
    }

    @GetMapping("/{productid}")
    public ResponseEntity<GetSingleProductResponseDto>  getSingleProduct(@PathVariable("productid") Long productid) throws NotFoundException {
        MultiValueMap<String,String> header= new LinkedMultiValueMap<>();
        header.add("auth-token","Sorry!No access");
        GetSingleProductResponseDto getSingleProductResponseDto= new GetSingleProductResponseDto();
//       return  productService.getSingleProduct(productid);
        Optional<Product> productoptional = productService.getSingleProduct(productid);
        getSingleProductResponseDto.setProduct(productoptional.get());
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

    @PatchMapping ("/{productid}")
    public ResponseEntity<UpdateProductResponseDto>  updateProduct(@PathVariable("productid") Long productid, @RequestBody ProductsDto productsDto )
    {

        Product product= new Product();
        Category category= new Category();
//        categoryService.
        product.setCategory(category);

        product.getCategory().setName(productsDto.getCategory());
        product.setTitle(productsDto.getTitle());

        product.setPrice(productsDto.getPrice());
        product.setDescription(productsDto.getDescription());
        Product newproduct = productService.updateProduct(productid, product);
        UpdateProductResponseDto updateProductResponseDto=
                new UpdateProductResponseDto();
        updateProductResponseDto.setProduct(newproduct);
        ResponseEntity<UpdateProductResponseDto> response =
                new ResponseEntity<>(updateProductResponseDto,HttpStatus.OK);
        return response;

    }
    @DeleteMapping("/{productid}")
    public String deleteProduct(@PathVariable("productid") Long productid)
    {
        return "Deleting One Product : "+ productid;
    }




}
