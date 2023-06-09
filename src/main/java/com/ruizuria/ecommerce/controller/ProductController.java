package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.dto.PageDto;
import com.ruizuria.ecommerce.dto.ProductDto;
import com.ruizuria.ecommerce.entity.Product;
import com.ruizuria.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductDto dto) {
        Product productSaved = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id,
                                          @RequestBody ProductDto dto) {
        Product productUpdated = productService.update(id,dto);
        return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        Product productFound = productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productFound);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Product>> getProducts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.getProducts(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productPage);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<PageDto> getProductsByCategory(
            @PathVariable Integer categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        PageDto productPage = productService.getByCategoryId(categoryId,pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productPage);
    }

    @GetMapping
    public ResponseEntity<PageDto> getFilteredProducts(
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
        PageDto productPage = productService.getFilteredProducts(minPrice, maxPrice, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productPage);
    }

}

