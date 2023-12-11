package com.bitan.pdtserv.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNewProductDto {
    private  String title;
    private  double price;
    private String description,image,category;

}
