package com.example.Buoi5_HoangThanhHai.service;

import com.example.Buoi5_HoangThanhHai.model.Category;
import com.example.Buoi5_HoangThanhHai.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> list = categoryRepository.findAll();
        return list == null ? new java.util.ArrayList<>() : list;
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

