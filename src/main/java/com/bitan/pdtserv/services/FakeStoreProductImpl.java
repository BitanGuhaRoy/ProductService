package com.bitan.pdtserv.services;

import com.bitan.pdtserv.dtos.FakeStoreProductDto;
import com.bitan.pdtserv.dtos.ProductsDto;
import com.bitan.pdtserv.models.Category;
import com.bitan.pdtserv.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
//Calling third party API, Fake Store
@Service
public class FakeStoreProductImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override

    public List<Product> getAllProducts() {

RestTemplate restTemplate= restTemplateBuilder.build();
ResponseEntity<FakeStoreProductDto[]> listResponseEntity=
        restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class );
//restTemplate.getForEntity()
  List<Product> answer= new ArrayList<>();
  for(FakeStoreProductDto obj: listResponseEntity.getBody() )
  {
      FakeStoreProductDto fakeStoreProductDto= (FakeStoreProductDto) obj;
      Product product= new Product();
      Category category= new Category();

      category.setName(fakeStoreProductDto.getCategory());
      product.setCategory(category);
      product.setImageref(fakeStoreProductDto.getImage());
      product.setTitle(fakeStoreProductDto.getTitle());
      product.setPrice(fakeStoreProductDto.getPrice());
      product.setId(fakeStoreProductDto.getId());
      product.setDescription(fakeStoreProductDto.getDescription());
      answer.add(product);

  }
        return answer;

    }

    @Override
    public Product getSingleProduct(Long productid) {

//        Product product= new Product();

        RestTemplate restTemplate= restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,productid);
         //url, return type,
        Product product= new Product();
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        Category category= new Category();

        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setImageref(fakeStoreProductDto.getImage());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        return product;
    }

    @Override
    public Product addNewProduct(ProductsDto products) {
//       RestTemplateBuilder restTemplateBuilder1
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.postForEntity("https://fakestoreapi.com/products",products,FakeStoreProductDto.class);


        FakeStoreProductDto productsDto = response.getBody();
        Product product= new Product();
        Category category= new Category();

        category.setName(productsDto.getCategory());
        product.setCategory(category);
        product.setImageref(productsDto.getImage());
        product.setTitle(productsDto.getTitle());
        product.setPrice(productsDto.getPrice());
        product.setId(productsDto.getId());
        product.setDescription(productsDto.getDescription());
        return product;

    }

    @Override
    public Product updateProduct(Long productid, Product product) {

        RestTemplate restTemplate = restTemplateBuilder.build();

      //  restTemplate.patchForObject("")
//        restTemplate
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productid) {
        return null;
    }
}
