package com.onlineShop.model;
/*
 *  Created by Solomon
 *
 * */

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
public class OrderDetail {

    @Id
    @GeneratedValue
    private int orderDetailId;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    public OrderDetail() {
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
