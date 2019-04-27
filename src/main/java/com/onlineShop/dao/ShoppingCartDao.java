package com.onlineShop.dao;

import com.onlineShop.model.OrderPayment;

public interface ShoppingCartDao {
    void addOrderPayment(OrderPayment orderPayment);
    void removeOrderPayment(OrderPayment orderPayment);
    OrderPayment findById(int id);
    OrderPayment findByStatus(String status, Integer customerId);
}
