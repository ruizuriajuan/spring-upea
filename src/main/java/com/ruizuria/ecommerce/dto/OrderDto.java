package com.ruizuria.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.ruizuria.ecommerce.entity.OrderState;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String comment;
    private Integer idUser;
    @JsonProperty(access = Access.READ_ONLY)
    private Double totalPrice;
    @JsonProperty(access = Access.READ_ONLY)
    private OrderState state;
    private List<OrderItemDto> items;
}
