package com.bitan.pdtserv.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Category extends  Base{
    private  String name;
    private  String description;
    private List<Product> products;
}
