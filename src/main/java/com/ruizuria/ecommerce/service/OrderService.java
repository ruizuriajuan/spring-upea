package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.dto.OrderDto;
import com.ruizuria.ecommerce.dto.OrderItemDto;
import com.ruizuria.ecommerce.entity.Order;
import com.ruizuria.ecommerce.entity.OrderItem;
import com.ruizuria.ecommerce.entity.User;
import com.ruizuria.ecommerce.mapper.OrderMapper;
import com.ruizuria.ecommerce.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductService productService;
    @Autowired
    OrderMapper orderMapper;

    public String create (OrderDto dto){
        Order order = new Order();
        order.setComment(dto.getComment());
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order.setUser(user);

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

    public OrderDto getById(Integer id){
        Order order = orderRepository.findById(id).orElseThrow( ()-> new EntityNotFoundException("Orden no existe"));
        order.setTotal(orderRepository.getTotalPrice(id));
        OrderDto dto = orderMapper.toOrderDto(order);
        dto.setItems(orderRepository.getItemsWithTotalPrice(id));
        return dto;
    }


}
