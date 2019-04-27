package com.onlineShop.model;

/*
 *  Created by Solomon 10/13/2018
 *  Online Shopping
 * */
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DynamicUpdate
public class Category {
    @Id
    @GeneratedValue
    private Integer categoryID;
    private String categoryName;


    public Integer getCategoryID() {

        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {

        this.categoryID = categoryID;
    }

    public String getCategoryName() {

        return categoryName;
    }

    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
