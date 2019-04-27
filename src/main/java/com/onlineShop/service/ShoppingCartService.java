package com.onlineShop.service;

import com.onlineShop.model.OrderPayment;

public interface ShoppingCartService {
    void add(OrderPayment orderPayment);
    void remove(OrderPayment orderPayment);
    OrderPayment findById(int id);
    OrderPayment findByState(String status, Integer customerId);
}
