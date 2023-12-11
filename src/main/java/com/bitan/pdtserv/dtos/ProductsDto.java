package com.bitan.pdtserv.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
public class ProductsDto {
     private Long id;
    private  String title;
    private  double price;
    private String description,image,category;

    @Override
    public String toString() {
        return
                "title=" + title + '\'' +
                ", price=" + price +
                ", description=" + description + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category
                ;
    }
}
