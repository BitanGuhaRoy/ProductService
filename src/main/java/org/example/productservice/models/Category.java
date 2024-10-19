package org.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.security.PrivateKey;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Category extends  Base{
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = {CascadeType.REMOVE})
    //@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    Set<Product > products;


}
