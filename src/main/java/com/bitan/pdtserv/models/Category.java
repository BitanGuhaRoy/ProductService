package com.bitan.pdtserv.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Category extends  Base{
    private  String name;
    private  String description;
    //mappedby is given to products, this is given to owning side(which deals with foreign key)
    @OneToMany(mappedBy ="category", fetch = FetchType.LAZY)
    private List<Product> products;

}
