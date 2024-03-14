package com.bitan.pdtserv.controllers;

import com.bitan.pdtserv.models.Product;
import com.bitan.pdtserv.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest // springboot container should start with this annotation
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    @Qualifier("selfProductService")
    private ProductService productService;

    @Test
    void testSomething()
    {
        int i= Math.abs(-2);
        assert (i==2);

    }

    @Test
    void getAllProductsShouldReturnEmptyListWhenNoProduct()
    {
        List<Product> l = new ArrayList<>();
        Product p1= new Product();
        p1.setPrice(109.95);
        l.add(p1);

          when(productService.getAllProducts()).thenReturn(l);
          //productService is hard coded. It is not a real service
        //Name should say what is the expected result that is being tested\
//        List<Product> products= productController.getAllProducts("token");  <-->

         //assert(109.95==products.get(0).getPrice());
        //assertTrue(109.95==products.get(0).getPrice());

//        assertEquals (109.95,products.get(0).getPrice());         <-->

        //it fails if productController or productService makes anything wrong
        //1. Bug in productservice
        //2. Bug in productcontroller

        //here we are testing the productcontroller
        // either bug can be in 3rd party or bug can be in your code

        //say controller have bug, normally it is integration test

        // we have to hard code the dependency that is service
        // we have to mock the service
      //even after that if test case fails then the issue must be in the controller only

    }

}