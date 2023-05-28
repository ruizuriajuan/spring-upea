package com.ruizuria.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private int stock;
    private boolean active;
    private Integer categoryId;
}

