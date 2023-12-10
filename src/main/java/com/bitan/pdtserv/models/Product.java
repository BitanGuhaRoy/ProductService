package com.bitan.pdtserv.models;

import com.sun.jdi.event.StepEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base{

    private String title,description,imageref;
    private double price;
    private Category category;
}
