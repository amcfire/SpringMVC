package com.onlineShop.service;


import com.onlineShop.model.Administrator;
import com.onlineShop.model.Customer;

import java.util.List;

/**
     * Created by IntelliJ IDEA.
     *   User: krish
     *   Date: 10/14/2018
     *   Time: 8:29 AM
     */
    public interface AdminService {
        public Customer getCustomer(int id);
        public List<Customer> getAllCustomer();

        public int create(Customer customer);
        public Customer update(Customer customer);
        public void delete(int id);

        void addCustomer(Customer customer);

        public List<Administrator> getAllAdmin();
        public void addAdmin(Administrator administrator);
    }


