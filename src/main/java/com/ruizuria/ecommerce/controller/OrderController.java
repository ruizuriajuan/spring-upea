package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.dto.OrderDto;
import com.ruizuria.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<String> create (@RequestBody OrderDto dto){
        String message = orderService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
