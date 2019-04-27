package com.onlineShop.service.impl;

import com.onlineShop.dao.OrderDetailDao;
import com.onlineShop.model.OrderDetail;
import com.onlineShop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;

    public void addOrderDetail(OrderDetail orderDetail){
        orderDetailDao.addItem(orderDetail);
    }
    public void deleteOrderDetail(OrderDetail orderDetail){
        orderDetailDao.removeItem(orderDetail);
    }
    public OrderDetail findById(Integer orderDetailId){
        return orderDetailDao.findByID(orderDetailId);
    }

    @Override
    public List<OrderDetail> findByOrderPaymentId(int orderPaymentId) {
        return orderDetailDao.findByOrderPaymentID(orderPaymentId);
    }
}
