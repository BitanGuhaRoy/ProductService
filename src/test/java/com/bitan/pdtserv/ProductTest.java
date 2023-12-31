package com.bitan.pdtserv;

import com.bitan.pdtserv.models.Category;
import com.bitan.pdtserv.models.Product;
import com.bitan.pdtserv.repository.CategoryRepository;
import com.bitan.pdtserv.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired
private ProductRepository productRepository;
    @Autowired
private CategoryRepository categoryRepository;
    @Test
    void savingProductsAndCategory()
    {
        Product product= new Product();
        Category category= new Category();
        category.setName("Mobile");
        Category savedcategory =categoryRepository.save(category);
        product.setCategory(category);
        product.setPrice(100);
        product.setImageref("hello");
        product.setDescription("Sweat-shirt");
        Product savedproduct= productRepository.save(product);

    }

    @Test
    void deleteTest()
    {
         categoryRepository.deleteById(252L);

//       //mapping multiple products in a category
//        Product product= new Product();
////        Category category= new Category();
//        Category category=categoryRepository.findCategoryById(102L);
////        category.setName("Mobile");
////        Category savedcategory =categoryRepository.save(category);
//        product.setCategory(category);
//        product.setPrice(5600);
//
//        product.setImageref("hello");
//        product.setDescription("Sweat-shirt");
//        Product savedproduct= productRepository.save(product);

    }
    @Test
    @Transactional
    void fetchTypeTest()
    {
        //Eager loading
       Product product = productRepository.findProductById(1L);//corresponding category will also be fetched


        System.out.println("Product fetched");

        product.getCategory();

    }
}
