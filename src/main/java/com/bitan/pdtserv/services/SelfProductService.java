package com.bitan.pdtserv.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bitan.pdtserv.Exception.NotFoundException;
import com.bitan.pdtserv.dtos.ProductsDto;
import com.bitan.pdtserv.models.Category;
import com.bitan.pdtserv.models.Product;
import com.bitan.pdtserv.repository.CategoryRepository;
import com.bitan.pdtserv.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
@Service("selfProductService")
public class SelfProductService implements ProductService
{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {

        System.out.println("Getting all products");
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getSingleProduct(Long productid) throws  NotFoundException {


       Product product= (productRepository.findProductById(productid));

        if(product==null)
        {
            throw new NotFoundException("No product exists on this Id");
        }

        return Optional.of(product);
    }

    @Override
    public Product addNewProduct(ProductsDto productsDto) {

            Product product= new Product();
            product.setPrice(productsDto.getPrice());
            product.setImageref(productsDto.getImage());
            product.setDescription(productsDto.getDescription());
            product.setTitle(productsDto.getTitle());
            Category category= new Category();
            category.setName(productsDto.getCategory());
            product.setCategory(category);;
            categoryRepository.save(category);
            return productRepository.save(product);


    }

    @Override
    public Product updateProduct(Long productid,Product product) {

        product.setId(productid);
        if(productRepository.findById(productid).isPresent()) {
            deleteProduct(productid);
        }

        Category c= product.getCategory();
        categoryRepository.save(c);

//            product.setId(productid);
            return productRepository.save(product);



        }

    @Override
    public Boolean deleteProduct(Long productid) {


        Optional<Product> product= productRepository.findById(productid);
        if(product.isPresent())
        {
            productRepository.deleteById(productid);
            return true;
        }
        return false;

//        return productRepository.deleteById();
    }




}
