package com.bitan.pdtserv.services;
//import  org.apache.Cli
import com.bitan.pdtserv.dtos.FakeStoreProductDto;
import com.bitan.pdtserv.dtos.ProductsDto;
import com.bitan.pdtserv.models.Category;
import com.bitan.pdtserv.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
//Calling third party API, Fake Store
@Service
public class FakeStoreProductImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    private static <T> T nonNull(@Nullable T result) {
        Assert.state(result != null, "No result");
        return result;
    }
    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request,
                                               Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate =
                restTemplateBuilder.requestFactory (HttpComponentsClientHttpRequestFactory.class).build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return nonNull(restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables));
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
    public Optional<Product> getSingleProduct(Long productid) {

//        Product product= new Product();

        RestTemplate restTemplate= restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,productid);
         //url, return type,
        Product product= new Product();
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        Category category= new Category();
        if(fakeStoreProductDto==null)
        {
            return Optional.empty();
        }
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setImageref(fakeStoreProductDto.getImage());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        return Optional.of(product);
//        return product;
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

//        HttpComponentsClientHttpRequestFactory
        RestTemplate restTemplate =
                restTemplateBuilder.requestFactory (HttpComponentsClientHttpRequestFactory.class).build();

//                restTemplateBuilder.build();


        FakeStoreProductDto fakeStoreProductDto= new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageref());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=
        requestForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/products/{id}"
                ,fakeStoreProductDto,FakeStoreProductDto.class,productid );



        FakeStoreProductDto productsDto = fakeStoreProductDtoResponseEntity.getBody();
        Product product1= new Product();
        Category category= new Category();

        category.setName(productsDto.getCategory());
        product1.setCategory(category);
        product1.setImageref(productsDto.getImage());
        product1.setTitle(productsDto.getTitle());
        product1.setPrice(productsDto.getPrice());
        product1.setId(productsDto.getId());
        product1.setDescription(productsDto.getDescription());
        return product1;

//        return null;
    }

    @Override
    public Boolean deleteProduct(Long productid) {
        return null;
    }
}
