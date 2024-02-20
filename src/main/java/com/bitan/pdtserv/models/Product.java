package com.bitan.pdtserv.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.jdi.event.StepEvent;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Builder
public class Product extends Base{

    private String title;
    private String description;
    private String imageref;
    private double price;
    //eager loading
    @ManyToOne( fetch = FetchType.EAGER
            //, cascade = {CascadeType.PERSIST, CascadeType.REMOVE} // adding this will create issue while saving product
    )


    private Category category;
    private Boolean ispublic;
}
