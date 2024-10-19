package org.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;


@Getter
@Setter
@Entity
public class Product  extends Base{
    private String name;
    private String description;
    private double price;
    private String image;
    @ManyToOne( cascade = {CascadeType.PERSIST})
    //(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
}
