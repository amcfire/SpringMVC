package com.onlineShop.model.model_DTO;

import com.onlineShop.model.Category;
import com.onlineShop.model.Vendor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/*
 *  Created by Solomon 10/21/2018
 *  Online Shopping
 *
 *  Product DTO
 * */


@Repository
public class Product_Dao implements Serializable {


    @NotEmpty(message = "product Name Can't be Empty.")
    private String productName;

    private String productDescription;

    @Min(value = 0, message = "Price should be a number.")
    private int productPrice;
    @Min(value = 0)
    @Max(value = 1000, message = "you can only have upto 1000 units in the stock. ")
    private int unitInStock;

    private String flag;
    @Past(message = "Creation Date can't be in the future")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date creationDate;

    //@NotNull
    private String mainPicturePath;

    private Category category;

    private Vendor vendor_id;

    private List<MultipartFile> inputImages;



    public Vendor getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Vendor vendor_id) {
        this.vendor_id = vendor_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<MultipartFile> getInputImages() {
        return inputImages;
    }

    public void setInputImages(List<MultipartFile> inputImages) {
        this.inputImages = inputImages;
    }

    public String getMainPicturePath() {
        return mainPicturePath;
    }

    public void setMainPicturePath(String mainPicturePath) {
        this.mainPicturePath = mainPicturePath;
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
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




    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
