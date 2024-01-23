package com.bitan.pdtserv.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
@Getter
@Setter
@Entity
public class Category extends  Base{
    private  String name;
    private  String description;
    //mappedby is given to products, this is given to owning side(which deals with foreign key)
    @OneToMany(mappedBy ="category", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private List<Product> products;


//    Hibernate: select c1_0.id,c1_0.created_at,c1_0.description,c1_0.isdeleted,c1_0.last_updated,c1_0.name from category c1_0 where c1_0.id in (?,?)
//    Hibernate: select p1_0.category_id,p1_0.id,p1_0.created_at,p1_0.description,p1_0.imageref,p1_0.isdeleted,p1_0.last_updated,p1_0.price,p1_0.title from product p1_0 where p1_0.category_id=?
//            100.0
//    Hibernate: select p1_0.category_id,p1_0.id,p1_0.created_at,p1_0.description,p1_0.imageref,p1_0.isdeleted,p1_0.last_updated,p1_0.price,p1_0.title from product p1_0 where p1_0.category_id=?
//            100.0
}
