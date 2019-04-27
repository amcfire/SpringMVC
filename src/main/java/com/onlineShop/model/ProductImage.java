package com.onlineShop.model;

/**
 * Created by Solomon.
 * online Shopping 10/13/2018
 *
 */

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@DynamicUpdate
public class ProductImage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int productImageId;
    @NotNull
    private String url;

    public ProductImage() {
    }

    public ProductImage(String url) {

        this.url = url;
    }
    public ProductImage(int productImageId, String url) {
        this.url = url;
        this.productImageId = productImageId;
    }

    public int getProductImageId() {

        return productImageId;
    }

    public void setProductImageId(int productImageId) {

        this.productImageId = productImageId;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
