package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.dto.UserDto;
import com.ruizuria.ecommerce.entity.Role;
import com.ruizuria.ecommerce.entity.User;
import com.ruizuria.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        UserDto userFound = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userFound);
    }
}
