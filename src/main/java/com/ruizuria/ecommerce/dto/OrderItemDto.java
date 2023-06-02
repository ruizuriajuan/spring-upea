package com.ruizuria.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDto {
    private Integer idProduct;
    private Integer quantity;
    @JsonProperty(access = Access.READ_ONLY)
    private BigDecimal totalPrice;


    public OrderItemDto(Integer idProduct, Integer quantity, BigDecimal totalPrice) {
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
