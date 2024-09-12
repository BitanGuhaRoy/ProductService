package org.example.productservice.inheritancerepresentation.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")
public class Ta extends User {

    private int numberOfSessions;
    private double avgRating;
}
