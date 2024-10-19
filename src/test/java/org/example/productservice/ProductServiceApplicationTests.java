package org.example.productservice;

import org.example.productservice.models.Category;
import org.example.productservice.models.Product;
import org.example.productservice.repository.CategoryRepository;
import org.example.productservice.repository.ProductRepository;
import org.example.productservice.repository.projections.ProductWithNameAndId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void test() {
//   categoryRepository.deleteById(102L);
      Optional<Category> category = categoryRepository.findById(103L);

      if(category.isPresent())
      {
          Set<Product> products = category.get().getProducts();
          for(Product product: products)
          {
              System.out.println(product.getName());
          }
      }
      else{
          System.out.println("category not found");
      }


    }

    @Test
    void testLazyLoading() {
        Product product = productRepository.findByIdCustom(53L);
        System.out.println(product.getName());
//        Category category = product.getCategory();


    }

}
