package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.entity.Category;
import com.ruizuria.ecommerce.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category getById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public Category update(Integer id, Category category) {
        Category categoryFound = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));
        categoryFound.setName(category.getName() == null ? categoryFound.getName() : category.getName());
        categoryFound.setDescription(category.getDescription() == null ? categoryFound.getDescription() : category.getDescription());
        categoryFound.setActivo(category.isActivo());
        return create(categoryFound);
    }

    public void deleteById(Integer id) {
        Category categoryFound = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));
        categoryFound.setActivo(false);
        create(categoryFound);
    }


}
