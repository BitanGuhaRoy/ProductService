package org.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product  extends Base{
    private String name;
    private String description;
    private double price;
    private String image;
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

}
