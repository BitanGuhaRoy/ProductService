package com.bitan.pdtserv.InheritanceRelation.mappedsuperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@MappedSuperclass

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  String email;
    private  String password;

}
