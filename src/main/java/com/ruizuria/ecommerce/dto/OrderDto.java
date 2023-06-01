package com.ruizuria.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String comment;
    private Integer idUser;
    private List<OrderItemDto> items;
}
