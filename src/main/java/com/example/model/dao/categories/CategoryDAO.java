package com.example.model.dao.categories;

import com.example.model.entity.categories.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    boolean add(Category category);
    Category findById(int id);
    boolean update(Category category);
    boolean delete(int id);
}
