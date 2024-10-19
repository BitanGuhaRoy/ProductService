package org.example.productservice.service;

import org.apache.commons.logging.Log;
import org.example.productservice.dtos.FakeStoreProductDto;
import org.example.productservice.dtos.ProductCreatedResponseDto;
import org.example.productservice.exceptions.InvalidProductException;
import org.example.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("ProductServiceFakeStoreCall")
public class ProductServiceFakeStoreCall implements  ProductService{
   @Autowired
   private RestTemplate restTemplate;

     private FakeStoreProductDto getProductDto(Product product){
         FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
         fakeStoreProductDto.setId(product.getId());
         fakeStoreProductDto.setTitle(product.getName());
         fakeStoreProductDto.setDescription(product.getDescription());
         fakeStoreProductDto.setPrice(product.getPrice());
         fakeStoreProductDto.setImage(product.getImage());
         fakeStoreProductDto.setCategory(product.getCategory().getName());
         return fakeStoreProductDto;
     }
     {}
    public Product getProductById(Long id) throws InvalidProductException {
        String url= "https://fakestoreapi.com/products/"+id;
        ResponseEntity<FakeStoreProductDto> responseEntity= restTemplate.getForEntity(url, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        HttpStatusCode httpStatusCode= responseEntity.getStatusCode();
//        fakeStoreProductDto=null;
//        @TODO: How to handle error/ exception without exposing every detail to client(chrome )
        if(fakeStoreProductDto==null)
        {

            throw new InvalidProductException("Product not found");
        }
        if( httpStatusCode!= HttpStatus.OK){
            return new Product();
        }

        return fakeStoreProductDto.toProduct();
    }


    public List<Product> getAllProducts() {

//        List<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", List.class);
         FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
//         @TODO: why array is used here and not list(lec Nuances Wrt ApI's And Response Entity)
        List<Product> products = new ArrayList<>();
        if (fakeStoreProductDtos != null) {

            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                products.add(fakeStoreProductDto.toProduct());
            }


        }
        return products;

    }


    public ProductCreatedResponseDto createProduct(Product product) {
        return null;
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
