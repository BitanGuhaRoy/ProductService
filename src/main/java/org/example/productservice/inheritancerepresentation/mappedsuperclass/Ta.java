package org.example.productservice.inheritancerepresentation.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_ta")
public class Ta extends User{

    private int numberOfSessions;
    private double avgRating;
}
