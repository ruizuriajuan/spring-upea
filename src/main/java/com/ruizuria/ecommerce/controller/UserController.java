package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.dto.UserDto;
import com.ruizuria.ecommerce.entity.Role;
import com.ruizuria.ecommerce.entity.User;
import com.ruizuria.ecommerce.service.AuthenticationService;
import com.ruizuria.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        UserDto userFound = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userFound);
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(dto));
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirm(@RequestParam String token) {
        String msg = userService.confirm(token);
        return ResponseEntity.status(HttpStatus.OK).body(msg );
    }

    @PostMapping("/login")
    public ResponseEntity<String> autenticate(@RequestParam String user, @RequestParam String password){
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticate(user,password));
    }

}
