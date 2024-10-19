package org.example.productservice.repository;

import org.example.productservice.exceptions.ProductDoesnotExistException;
import org.example.productservice.models.Product;
import org.example.productservice.repository.projections.ProductWithNameAndId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
       Optional<Product> findByNameAndDescription(String name, String description);

         List<Product> findByNameContaining(String word); //uses like

       List<Product> findTopThreeByName(String word); //uses limit

       Product save(Product product);

    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> getMeProductById(Long id);

    // This is how we deal with projections in spring data jpa
    //we are supposed to put alias (as name as id) in the query otherwise it will not work
    @Query("SELECT p.name as name, p.id as id FROM Product p WHERE p.id = :id")
    ProductWithNameAndId getMeProductIdAndName(Long id);


    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Product findByIdCustom(Long id);




}
