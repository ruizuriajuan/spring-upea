package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.dto.ProductDto;
import com.ruizuria.ecommerce.entity.Category;
import com.ruizuria.ecommerce.entity.Product;
import com.ruizuria.ecommerce.mapper.ProductMapper;
import com.ruizuria.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductMapper productMapper;


    public Product create(ProductDto dto) {
        Category category = categoryService.getById(dto.getCategoryId());
        Product product = productMapper.toProduct(dto);
        product.setCategory(category);
        return productRepository.save(product);
    }


    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }


    /*
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    public PageDto<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable) {
        Page<Product> page = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        return productMapper.fromEntity(page);
    }*/

}
