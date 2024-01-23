package com.bitan.pdtserv.models;

import com.sun.jdi.event.StepEvent;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Builder
public class Product extends Base{

    private String title,description,imageref;
    private double price;

    //eager loading
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Category category;
    private Boolean ispublic;
}
