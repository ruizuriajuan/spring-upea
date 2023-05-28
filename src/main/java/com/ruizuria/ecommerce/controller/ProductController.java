package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.dto.ProductDto;
import com.ruizuria.ecommerce.entity.Product;
import com.ruizuria.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDto dto) {
        Product productSaved = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        Product productFound = productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productFound);
    }
/*
    @GetMapping("/pageable")
    public ResponseEntity<Page<Product>> getProducts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.getProducts(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productPage);
    }

    @GetMapping
    public ResponseEntity<PageDto<Product>> getFilteredProducts(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        if (minPrice == null) {
            minPrice = Double.MIN_VALUE;
        }
        if (maxPrice == null) {
            maxPrice = Double.MAX_VALUE;
        }
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        PageDto<Product> productPage = productService.getFilteredProducts(minPrice, maxPrice, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productPage);
    }
*/
}

