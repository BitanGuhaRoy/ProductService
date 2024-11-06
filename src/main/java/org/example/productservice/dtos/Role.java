package org.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Role {
    private List<User> users;
    private String name;
}
