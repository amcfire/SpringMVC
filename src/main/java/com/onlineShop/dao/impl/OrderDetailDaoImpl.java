package com.onlineShop.dao.impl;

import com.onlineShop.dao.OrderDetailDao;
import com.onlineShop.model.OrderDetail;
import com.onlineShop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@DynamicUpdate
@Transactional
public class OrderDetailDaoImpl implements OrderDetailDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addItem(OrderDetail orderDetail){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderDetail);
        session.flush();
    }

    @Override
    public void removeItem(OrderDetail orderDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(orderDetail);
        session.flush();
    }

    @Override
    public OrderDetail findByID(int orderDetailId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetail where orderDetailId = ?");
        query.setInteger(0, orderDetailId);
        return (OrderDetail) query.uniqueResult();
    }

    @Override
    public List<OrderDetail> findByOrderPaymentID(int orderPaymentId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetail where orderPaymentId = ?");
        query.setInteger(0, orderPaymentId);
        return (List<OrderDetail>) query.uniqueResult();
    }
}
