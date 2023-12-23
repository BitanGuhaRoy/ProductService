package com.bitan.pdtserv.models;

import com.sun.jdi.event.StepEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends Base{

    private String title,description,imageref;
    private double price;
    @ManyToOne
    private Category category;
}
