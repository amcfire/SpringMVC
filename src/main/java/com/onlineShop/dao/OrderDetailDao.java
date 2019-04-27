package com.onlineShop.dao;

import com.onlineShop.model.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    void addItem(OrderDetail orderDetail);
    void removeItem(OrderDetail orderDetail);
    OrderDetail findByID(int orderDetailId);
    List<OrderDetail> findByOrderPaymentID(int orderPaymentId);
}
