package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.entity.Category;
import com.ruizuria.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Integer id) {
        Category categoryFound = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryFound);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        Category categoryFound = service.create(category);
        return ResponseEntity.status(HttpStatus.OK).body(categoryFound);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> save(@PathVariable Integer id,
                                         @RequestBody Category category) {
        Category categoryFound = service.update(id, category);
        return ResponseEntity.status(HttpStatus.OK).body(categoryFound);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteById(id);
    }
}
