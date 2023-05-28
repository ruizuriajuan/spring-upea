package com.ruizuria.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String description;
    private boolean activo;
}
