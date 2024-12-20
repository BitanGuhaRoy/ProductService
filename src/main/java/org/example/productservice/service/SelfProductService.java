package org.example.productservice.service;

import org.example.productservice.dtos.ProductCreatedCategoryDto;
import org.example.productservice.dtos.ProductCreatedResponseDto;
import org.example.productservice.exceptions.ProductDoesnotExistException;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;
import org.example.productservice.repository.CategoryRepository;
import org.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ProductServiceSelfCall")
public class SelfProductService implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Product getProductById(Long id) throws ProductDoesnotExistException {

       Optional<Product> product =  productRepository.findById(id);
         if(product.isPresent())
         {
             return product.get();
         }
        else {
            throw new ProductDoesnotExistException("product does not exist with id :"+ id);
         }
    }

    @Override
    public ProductCreatedResponseDto createProduct(Product product) {


        if(product.getCategory().getId()==null)
        {
            Category category = product.getCategory();

            Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());

            if(categoryOptional.isPresent())
            {
                product.setCategory(categoryOptional.get());
            }
            else{
                Category newCategory = categoryRepository.save(product.getCategory());
                product.setCategory(newCategory);

            }
        }

       Product productCreated=  productRepository.save(product);

        return toProductCreatedResponseDto(productCreated);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    private ProductCreatedResponseDto toProductCreatedResponseDto(Product product)
    {
        ProductCreatedResponseDto productCreatedResponseDto = new ProductCreatedResponseDto();
        productCreatedResponseDto.setId(product.getId());
        productCreatedResponseDto.setName(product.getName());
        productCreatedResponseDto.setDescription(product.getDescription());
        productCreatedResponseDto.setPrice(product.getPrice());
        productCreatedResponseDto.setImage(product.getImage());
        ProductCreatedCategoryDto productCreatedCategoryDto = new ProductCreatedCategoryDto();
        productCreatedCategoryDto.setName(product.getCategory().getName());
        productCreatedResponseDto.setCategoryDto(productCreatedCategoryDto);
        return productCreatedResponseDto;
    }
}
