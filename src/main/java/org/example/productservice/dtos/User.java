package org.example.productservice.dtos;

import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User {
    private String username;
    private String password;
    private String email;

    private List<Role> roles;
    private Boolean isEmailVerified;
}
