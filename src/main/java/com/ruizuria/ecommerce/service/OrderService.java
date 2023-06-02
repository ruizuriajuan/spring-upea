package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.dto.OrderDto;
import com.ruizuria.ecommerce.entity.Order;
import com.ruizuria.ecommerce.entity.OrderItem;
import com.ruizuria.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    public String create (OrderDto dto){
        Order order = new Order();
        order.setComment(dto.getComment());
        //TODO: de security obtener usuario

       List<OrderItem> items = dto.getItems().stream().map((itemDto)->{
            OrderItem item = new OrderItem();
            item.setQuantity(itemDto.getQuantity());
            item.setProduct(productService.getById(itemDto.getIdProduct()));
            item.setOrder(order);
            return item;
        }).toList();
       order.setItems(items);
       Order orderSaved = orderRepository.save(order);
       return "Order saved successfulley ";
    }


}
