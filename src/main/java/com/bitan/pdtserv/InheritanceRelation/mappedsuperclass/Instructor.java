package com.bitan.pdtserv.InheritanceRelation.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_instructor")

public class Instructor extends User {
    private  String company;
}
