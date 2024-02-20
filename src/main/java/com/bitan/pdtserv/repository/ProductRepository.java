package com.bitan.pdtserv.repository;

import com.bitan.pdtserv.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {



  // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  // JPA to SQL translation refer above link for more details

Product save(Product product);

Product findProductById(Long id);
//void deleteProductBy(Long id);
  List<Product> findAll();
  Product findProductByIdIs(Long id);
  void deleteById(Long id);

  @Query(value="select * from Product p where p.id = ?1",nativeQuery = true)
  Product laaoProductwithid(Long id);
  // This function isn't known to JPA repository so we need to define the sql query
  // you will get a row from db but who will create the object of product out that row ?
  // you need to create the object of product from the row you got from db
  // jack son will do that for you


   List<Product> findProductByCategory_NameAndCategory_Id(String name,Long id);

   // select * from product where category_name = 'Mobile' and category_id = 1;

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
