package com.bitan.pdtserv.services;

import com.bitan.pdtserv.Exception.NotFoundException;
import com.bitan.pdtserv.models.Product;
import com.bitan.pdtserv.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class SelfProductServiceTest {
@Autowired
@Qualifier("selfProductService")
private ProductService productService;
@MockBean
private ProductRepository productRepository;
      @Test
      void getSingleProductThrowsExceptionWhenNoProductFound()
      {

          when(productRepository.findProductById(any())).thenReturn(null);
           assertThrows(NotFoundException.class,()->productService.getSingleProduct(1L));
//

      }

}