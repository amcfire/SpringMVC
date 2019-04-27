package com.onlineShop.model;
/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@DynamicUpdate
public class Subscription {

    @Id
    @GeneratedValue
    private int id;

    private double amount;
    private double compPercentage;
    private double vendorPercentage;
    private double taxPercentage;
    private Date dateCreated;
    private String status;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCompPercentage() {
        return compPercentage;
    }

    public void setCompPercentage(double compPercentage) {
        this.compPercentage = compPercentage;
    }

    public double getVendorPercentage() {
        return vendorPercentage;
    }

    public void setVendorPercentage(double vendorPercentage) {
        this.vendorPercentage = vendorPercentage;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
