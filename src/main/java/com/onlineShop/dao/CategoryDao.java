package com.onlineShop.dao;

/*
 *  Created by Solomon 10/13/2018
 *  Online Shopping
 * */
import com.onlineShop.model.Category;
import java.util.List;


public interface CategoryDao {

    void editCategory(Category category);
    Category getCategoryById(int categoryId);
    List<Category> categoryList();
    Category findById(Integer categoryId);
}
