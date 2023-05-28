package com.ruizuria.ecommerce.repository;

import com.ruizuria.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
}


