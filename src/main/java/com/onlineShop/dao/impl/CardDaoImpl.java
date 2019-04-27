package com.onlineShop.dao.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.dao.CardDao;
import com.onlineShop.model.CardDetail;
import com.onlineShop.model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CardDaoImpl implements CardDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CardDetail> getCardList(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CardDetail where customerId = ? ");
        query.setInteger(0, userId);
        return (List<CardDetail>) query.list();
    }

    @Override
    public Customer getCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);

    }

    @Override
    public void addCardDetail(CardDetail cardDetail) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.get(Customer.class, 1);
        cardDetail.setCustomer(customer);
        session.saveOrUpdate(cardDetail);
        session.flush();
    }

    @Override
    public CardDetail getCardById(int cardId) {
        Session session = sessionFactory.getCurrentSession();
        return (CardDetail) session.get(CardDetail.class, cardId);
    }

}