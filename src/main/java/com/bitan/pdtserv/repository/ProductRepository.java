package com.bitan.pdtserv.repository;

import com.bitan.pdtserv.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {



  // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  // JPA to SQL translation refer above link for more details

Product save(Product product);
Product findProductById(Long id);
//void deleteProductBy(Long id);

  Product findProductByIdIs(Long id);



  Product findByPriceBetweenAndTitleIgnoreCaseLessThan(Double greaterThanEqualTo,Double smallerThanEqualTo,String title);

  //select * from product where price between 100 and 200 and title like '%a%';


  Product findByPriceLessThanEqual(Double price);
  //select * from product where price <= 100;

    Product findByPriceGreaterThanEqual(Double price);
    //select * from product where price >= 100;

  // productRepository.findByPriceLessThanEqual(100.0);

    // productRepository.findByPriceGreaterThanEqual(100.0);

  List<Product> findByImagerefIsNull();

  //select * from Product where imageref is null;


  List<Product> findByTitleIgnoreCaseStartingWith(String title);
  //select * from Product where title like 'a%';


  List<Product> findAllByispublicIs(boolean value);
  //select * from Product where ispublic = true;


}
