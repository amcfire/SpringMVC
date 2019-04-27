package com.onlineShop.service.impl;

import com.onlineShop.dao.ShoppingCartDao;
import com.onlineShop.model.OrderPayment;
import com.onlineShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    public void add(OrderPayment orderPayment){
        shoppingCartDao.addOrderPayment(orderPayment);
    }
    public void remove(OrderPayment orderPayment){
        shoppingCartDao.removeOrderPayment(orderPayment);
    }

    @Override
    public OrderPayment findById(int id) {
        return shoppingCartDao.findById(id);
    }

    @Override
    public OrderPayment findByState(String status, Integer customerId) {
        return shoppingCartDao.findByStatus(status, customerId);
    }
}
