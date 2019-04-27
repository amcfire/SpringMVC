package com.onlineShop.service;

import com.onlineShop.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    void addOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(OrderDetail orderDetail);

    OrderDetail findById(Integer orderDetailId);
    List<OrderDetail> findByOrderPaymentId(int orderPaymentId);
}
