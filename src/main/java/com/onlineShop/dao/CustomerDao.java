package com.onlineShop.dao;

import com.onlineShop.model.Customer;

import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */
public interface CustomerDao {

    void addCustomer(Customer customer);

    /**
     * Edit customer
     *
     * @author Mingwei He
     * @param customer
     */
    void editCustomer(Customer customer);

    Customer getCustomerByUserId(int userId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

}
