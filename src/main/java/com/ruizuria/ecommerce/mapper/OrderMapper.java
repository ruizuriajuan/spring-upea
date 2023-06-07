package com.ruizuria.ecommerce.mapper;

import com.ruizuria.ecommerce.dto.OrderDto;
import com.ruizuria.ecommerce.dto.OrderItemDto;
import com.ruizuria.ecommerce.entity.Order;
import com.ruizuria.ecommerce.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mappings({
    @Mapping(source = "total", target = "totalPrice"),
    @Mapping(source = "user.id", target = "idUser")
    })
    OrderDto toOrderDto(Order order);


    @Mappings({
            @Mapping(source = "orderItem.product.id", target = "idProduct"),
            @Mapping(source = "total", target = "totalPrice")
    })
    OrderItemDto toOrderItemDto(OrderItem orderItem);
    List<OrderItemDto> toListOrderItemDto(List<OrderItem> listItem);

}
