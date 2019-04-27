package com.onlineShop.dao;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.*;

import java.util.List;

public interface PaymentDao {
        OrderPayment getOrderPayment(int customerId);
        List<OrderDetail> getOrderDetail(int orderPaymentId);
        Subscription getSubscription();
        Product blockProduct(OrderPayment orderPaymentId);
        boolean checkOut(OrderPayment orderPaymentId);
        Messages getMsg(int msgId);
        boolean writeToFinTxns(OrderPayment orderPayment, Subscription subscription);
}
