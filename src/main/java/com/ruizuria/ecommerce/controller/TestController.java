package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.dto.OrderItemDto;
import com.ruizuria.ecommerce.dto.UserDto;
import com.ruizuria.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/total/{idOrder}")
    public ResponseEntity<String> getTotalPriceById(@PathVariable Integer idOrder) {
        BigDecimal totalNative = orderRepository.getTotalPriceByOrderId(idOrder);
        BigDecimal totalJpql = orderRepository.getTotalPrice(idOrder);
        String response = String.format("Total nativo : %s y total jpql: %s",totalNative,totalJpql);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/total/item/{idOrder}")
    public ResponseEntity<List<OrderItemDto>> getTotalItemPriceById(@PathVariable Integer idOrder) {
        List<OrderItemDto> response= orderRepository.getItemsWithTotalPrice(idOrder);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
