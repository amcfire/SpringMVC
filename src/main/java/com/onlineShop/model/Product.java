package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 *  Created by Solomon 10/13/2018
 *  Online Shopping
 * */

@Entity
@DynamicUpdate
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @NotEmpty(message = "product Name Can't be Empty.")
    private String productName;

    private String productDescription;

    @Min(value = 0, message = "Price should be a number.")
    private double productPrice;
    @Min(value = 0)
    @Max(value = 1000, message = "you can only have upto 1000 units in the stock. ")
    private int unitInStock;

    private String flag;

    private String mainPicturePath;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private List<ProductImage> productImageList;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor_id;

    @Past
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date creationDate;



    public String getMainPicturePath() {
        return mainPicturePath;
    }

    public void setMainPicturePath(String mainPicturePath) {
        this.mainPicturePath = mainPicturePath;
    }

    public Product() {

    }

    public Vendor getVendor_id() {

        return vendor_id;
    }

    public void setVendor_id(Vendor vendor_id) {

        this.vendor_id = vendor_id;
    }

    public Date getCreationDate() {

        return creationDate;
    }

    public void setCreationDate(Date creationDate) {

        this.creationDate = creationDate;
    }

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public Long getProductId() {

        return productId;
    }

    public void setProductId(Long productId) {

        this.productId = productId;
    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public String getProductDescription() {

        return productDescription;
    }

    public void setProductDescription(String productDescription) {

        this.productDescription = productDescription;
    }

    public double getProductPrice() {

        return productPrice;
    }

    public void setProductPrice(double productPrice) {

        this.productPrice = productPrice;
    }

    public int getUnitInStock() {

        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {

        this.unitInStock = unitInStock;
    }

    public String getFlag() {

        return flag;
    }

    public void setFlag(String flag) {

        this.flag = flag;
    }

    public List<ProductImage> getProductImageList() {

        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {

        this.productImageList = productImageList;
    }
}
