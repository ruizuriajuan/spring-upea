package com.ruizuria.ecommerce.repository;

import com.ruizuria.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Query Method
     * Con argumento Pageable devolvera un Page
    **/
    Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

    Page<Product> findByCategoryId(Integer categoryId, Pageable pageable);

}


