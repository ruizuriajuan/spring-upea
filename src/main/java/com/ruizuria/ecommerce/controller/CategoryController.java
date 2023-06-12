package com.ruizuria.ecommerce.controller;

import com.ruizuria.ecommerce.entity.Category;
import com.ruizuria.ecommerce.exception.ErrorResponse;
import com.ruizuria.ecommerce.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Category")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @Operation(
            summary = "Obtener categoria por id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Category Found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Category.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Category not Found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@Parameter(description = "Id de catogira para buscar")
                                            @PathVariable Integer id) {
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
