package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.entity.Role;
import com.ruizuria.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/name/{name}")
    public ResponseEntity<Role> getByName(@PathVariable String name){
        Role roleFound = roleService.getByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(roleFound);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll(){
        List<Role> roles = roleService.getAll();
        return ResponseEntity.ok(roles);

    }
}
