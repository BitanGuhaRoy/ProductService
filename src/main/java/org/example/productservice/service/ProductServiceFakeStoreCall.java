package org.example.productservice.service;

import org.example.productservice.dtos.FakeStoreProductDto;
import org.example.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("ProductServiceFakeStoreCall")
public class ProductServiceFakeStoreCall implements  ProductService{
   @Autowired
   private RestTemplate restTemplate;


    public Product getProductById(Long id) {
        String url= "https://fakestoreapi.com/products/"+id;
        ResponseEntity<FakeStoreProductDto> responseEntity= restTemplate.getForEntity(url, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        HttpStatusCode httpStatusCode= responseEntity.getStatusCode();
        if(fakeStoreProductDto==null || httpStatusCode!= HttpStatus.OK){
            return new Product();
        }

        return fakeStoreProductDto.toProduct();
    }


    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }


    public Product createProduct( Product product) {
        return product;
    }

    public Product updateProduct(Long id , Product product) {
        return product;
    }
    public Product replaceProduct(Long id ,Product product) {
        return product;
    }


    public Boolean deleteProduct(Long id) {
        return true;
    }
}
