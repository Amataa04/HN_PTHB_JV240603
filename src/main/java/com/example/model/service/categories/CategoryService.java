package com.example.model.service.categories;

import com.example.model.entity.categories.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    boolean add(Category category);
    Category findById(int id);
    boolean update(Category category);
    boolean delete(int id);
}
