package com.onlineShop.dao.impl;


import com.onlineShop.dao.AdminDao;
import com.onlineShop.model.Address;
import com.onlineShop.model.Administrator;
import com.onlineShop.model.Customer;
import com.onlineShop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *   User: krish
 *   Date: 10/14/2018
 *   Time: 8:29 AM
 */

@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    SessionFactory sessionFactory;

    public AdminDaoImpl() {
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

//        customer.getUser().setCustomer(customer);
        User newUser = customer.getUser();
        newUser.setUserName(customer.getUser().getUserName());
        newUser.setPassword(customer.getUser().getPassword());
        newUser.setIsActive(true);

        Address newAddress = customer.getAddress();
        newAddress.setCity(customer.getAddress().getCity());
        newAddress.setCountry(customer.getAddress().getCountry());
        newAddress.setState(customer.getAddress().getState());
        newAddress.setZipCode(customer.getAddress().getZipCode());
        newAddress.setStreet(customer.getAddress().getStreet());


        session.saveOrUpdate(customer);
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAddress);

        session.flush();
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public User deleteCustomer(int userId) {
        return null;

    }

    @Override
    public List<Customer> getAllCustomer() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;

    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public List<Administrator> getAllAdmin() {
        Session session = sessionFactory.getCurrentSession();
        Query query =session.createQuery("from Administrator");
        List<Administrator> administratorList = query.list();

        return administratorList;
    }

    @Override
    public void addAdmin(Administrator administrator) {
        Session session = sessionFactory.getCurrentSession();

        User newUser = administrator.getUser();
        newUser.setUserName(administrator.getUser().getUserName());
        newUser.setPassword(administrator.getUser().getPassword());
        newUser.setIsActive(true);

        session.saveOrUpdate(administrator);
        session.saveOrUpdate(newUser);

        session.flush();


    }
}