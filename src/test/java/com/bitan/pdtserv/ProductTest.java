package com.bitan.pdtserv;

import com.bitan.pdtserv.models.Category;
import com.bitan.pdtserv.models.Product;
import com.bitan.pdtserv.repository.CategoryRepository;
import com.bitan.pdtserv.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

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


    }

    @Test
    @Transactional // by default this transaction is rolled back so add rollback false
    @Rollback(value = false)
    void saveProductsForCategory()
    {
        Product product= new Product();

        Category category=categoryRepository.findCategoryById(102L);

        product.setCategory(category);
        product.setPrice(5600);

        product.setImageref("hello");
        product.setDescription("Sweat-shirt");
        Product savedproduct= productRepository.save(product);


        Category category1= new Category();
        category1.setName("Education");

        categoryRepository.save(category1);

        Category category2= new Category();
        category2.setName("Vehicle");
        category2.setId(1L);

        categoryRepository.save(category2);


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

    @Test
    @Transactional
    void getProductsForCategory()
    {

        List<Category> categories= categoryRepository.findAllByIdIn(List.of(2L, 52L));
//        Category category = categoryRepository.getReferenceById(2L);

        for(Category category: categories)
        {
            for(Product product: category.getProducts())
            {
                System.out.println(product.getPrice());
            }
        }


    }
}
