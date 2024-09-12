package org.example.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Category extends  Base{

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;
    private String name;
}
