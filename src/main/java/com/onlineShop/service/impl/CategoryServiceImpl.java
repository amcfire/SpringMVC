package com.onlineShop.service.impl;

import com.onlineShop.dao.CategoryDao;
import com.onlineShop.model.Category;
import com.onlineShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAllCategories(){

        return categoryDao.categoryList();
    }

    @Override
    public Category findById(Integer categoryId) {

        return categoryDao.findById(categoryId);
    }
}
