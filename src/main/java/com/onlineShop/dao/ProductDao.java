package com.onlineShop.dao;

import com.onlineShop.model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Integer prodId);
    List<Product> findByCategoryId(Integer categoryId);
    List<Product> findAll();
    List<Product> findPriceAndCategory(Integer categoryId, Double downPrice, Double upPrice);
    List<Product> findSimilarProd(String productName);
    List<Product> findSimilarProdWithRange(String productName, Double downPrice, Double upPrice);
    void Save(Product product);
    void update(Product product);
    Product getProductById(long id);
}
