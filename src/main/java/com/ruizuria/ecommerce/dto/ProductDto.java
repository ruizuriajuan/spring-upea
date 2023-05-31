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
    private Double price;
    private Integer stock;
    private Boolean active;
    private Integer categoryId;
}

