package com.onlineShop.dao.impl;


import com.onlineShop.Constant;
import com.onlineShop.dao.ShoppingCartDao;
import com.onlineShop.model.OrderPayment;
import com.onlineShop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@DynamicUpdate
@Transactional
public class ShoppingCardDaoImpl implements ShoppingCartDao{
    @Autowired
    SessionFactory sessionFactory;

    public void addOrderPayment(OrderPayment orderPayment){
        Session session = sessionFactory.getCurrentSession();
//        orderPayment.
        session.saveOrUpdate(orderPayment);
        session.flush();
    }
    public void removeOrderPayment(OrderPayment orderPayment){
        Session session = sessionFactory.getCurrentSession();
        if(null != orderPayment){
            session.delete(orderPayment);
            session.flush();
        }
    }

    @Override
    public OrderPayment findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderPayment where orderPaymentId = ?");
        query.setInteger(0, id);
        return (OrderPayment) query.uniqueResult();
    }

    @Override
    public OrderPayment findByStatus(String status, Integer customerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderPayment where orderStatus = ? and customerid = ?");
        query.setString(0, status);
        query.setInteger(1, customerId);
        return (OrderPayment) query.uniqueResult();
    }
}
