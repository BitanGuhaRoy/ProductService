package com.bitan.pdtserv.services;

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
ResponseEntity<ProductsDto[]> listResponseEntity=
        restTemplate.getForEntity("https://fakestoreapi.com/products", ProductsDto[].class );
  List<Product> answer= new ArrayList<>();
  for(ProductsDto obj: listResponseEntity.getBody() )
  {
      ProductsDto productsDto= (ProductsDto) obj;
      Product product= new Product();
      Category category= new Category();

      category.setName(productsDto.getCategory());
      product.setCategory(category);
      product.setImageref(productsDto.getImage());
      product.setTitle(productsDto.getTitle());
      product.setPrice(productsDto.getPrice());
      product.setId(productsDto.getId());
      product.setDescription(productsDto.getDescription());
      answer.add(product);

  }
        return answer;

    }

    @Override
    public Product getSingleProduct(Long productid) {

//        Product product= new Product();

        RestTemplate restTemplate= restTemplateBuilder.build();

        ResponseEntity<ProductsDto> response=
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductsDto.class,productid);
         //url, return type,
        Product product= new Product();
        ProductsDto productsDto = response.getBody();

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
    public Product addNewProduct(ProductsDto products) {
//       RestTemplateBuilder restTemplateBuilder1
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<ProductsDto> response=
                restTemplate.postForEntity("https://fakestoreapi.com/products",products,ProductsDto.class);


        ProductsDto productsDto = response.getBody();
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
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productid) {
        return null;
    }
}
