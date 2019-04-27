package com.onlineShop.model;
/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
public class VendorFinTxn {

    @Id
    @GeneratedValue
    private int id;

    private long productId;
    private double amount;
    private Date paidDate;
    private String status;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
