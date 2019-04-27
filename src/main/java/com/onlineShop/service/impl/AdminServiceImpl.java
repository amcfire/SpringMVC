package com.onlineShop.service.impl;

import com.onlineShop.dao.AdminDao;
import com.onlineShop.model.Administrator;
import com.onlineShop.model.Customer;
import com.onlineShop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created By krish on Oct, 2018
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    public AdminServiceImpl() {
    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {

        return adminDao.getAllCustomer();
    }

    @Override
    public int create(Customer customer) {
        return 0;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void addCustomer(Customer customer) {
        adminDao.addCustomer(customer);
    }

    @Override
    public List<Administrator> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public void addAdmin(Administrator administrator) {
        adminDao.addAdmin(administrator);
    }
}
