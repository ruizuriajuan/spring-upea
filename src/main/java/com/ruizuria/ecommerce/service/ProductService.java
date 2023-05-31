package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.dto.PageDto;
import com.ruizuria.ecommerce.dto.ProductDto;
import com.ruizuria.ecommerce.entity.Category;
import com.ruizuria.ecommerce.entity.Product;
import com.ruizuria.ecommerce.mapper.PageMapper;
import com.ruizuria.ecommerce.mapper.ProductMapper;
import com.ruizuria.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    private PageMapper pageMapper;


    public Product create(ProductDto dto) {
        Category category = categoryService.getById(dto.getCategoryId());
        Product product = productMapper.toProduct(dto);
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product update(Integer id, ProductDto change)  {
        Product productFound = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        if(change==null){
            return productFound;
        }
        productFound.setName(change.getName() == null ? productFound.getName() : change.getName());
        productFound.setDescription(change.getDescription() == null ? productFound.getDescription() : change.getDescription());
        productFound.setImageUrl(change.getImageUrl() == null ? productFound.getImageUrl() : change.getImageUrl());
        productFound.setPrice(change.getPrice() == null ? productFound.getPrice() : change.getPrice());
        productFound.setStock(change.getStock() == null ? productFound.getStock() : change.getStock());
        productFound.setActive(change.getActive() == null ? productFound.getActive() : change.getActive());
        Category categoryFound = change.getCategoryId() ==null? productFound.getCategory() : categoryService.getById(change.getCategoryId());
        productFound.setCategory(categoryFound);
        return productRepository.save(productFound);
    }


    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }


    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    public PageDto getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable) {
        Page<Product> page = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        return pageMapper.toPageDto(page);
    }

    public PageDto getByCategoryId(Integer categoryId, Pageable pageable) {
        Page<Product> page = productRepository.findByCategoryId(categoryId, pageable);
        return pageMapper.toPageDto(page);
    }
}
