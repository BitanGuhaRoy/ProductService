package org.example.productservice.inheritancerepresentation.singletable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Instructor extends User {

    private  String specializationTopic;
}
