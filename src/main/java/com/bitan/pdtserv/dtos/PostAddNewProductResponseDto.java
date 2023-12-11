package com.bitan.pdtserv.dtos;

import com.bitan.pdtserv.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAddNewProductResponseDto {
    Product product;
}
