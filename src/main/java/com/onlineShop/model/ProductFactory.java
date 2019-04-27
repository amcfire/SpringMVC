package com.onlineShop.model;

import com.onlineShop.model.model_DTO.Product_Dao;


/*
 *  Created by Solomon 10/21/2018
 *  Online Shopping
 * */

public class ProductFactory {
    private static ProductFactory INSTANCE = null;
    public ProductFactory(){

    }

    public static ProductFactory getINSTANCE(){
        if(INSTANCE==null){
            INSTANCE = new ProductFactory();

        }
        return INSTANCE;
    }

    public Product createUserFromDto(Product_Dao product) {

        Product product1 = new Product();

        product1.setProductName(product.getProductName());
        product1.setProductDescription(product.getProductDescription());
        product1.setFlag(product.getFlag());
        product1.setCategory(product.getCategory());
        product1.setCreationDate(product.getCreationDate());
        product1.setMainPicturePath(product.getMainPicturePath());
        product1.setUnitInStock(product.getUnitInStock());
        product1.setVendor_id(product.getVendor_id());
        product1.setProductPrice(product.getProductPrice());
        return product1;
    }
}
