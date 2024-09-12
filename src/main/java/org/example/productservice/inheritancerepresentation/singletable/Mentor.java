package org.example.productservice.inheritancerepresentation.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentor extends User {
     private String organization;

}
