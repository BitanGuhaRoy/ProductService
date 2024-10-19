package org.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreatedResponseDto {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String image;
//    private Long categoryId;
    private ProductCreatedCategoryDto categoryDto;
}
