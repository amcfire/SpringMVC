package com.onlineShop.service;

import com.onlineShop.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findById(Integer categoryId);
}
