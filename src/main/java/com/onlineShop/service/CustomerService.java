package com.onlineShop.service;

import com.onlineShop.model.Customer;
import com.onlineShop.model.User;

import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */
public interface CustomerService {

    void addCustomer(Customer Customer);
//asdas
    /**
     * Edit customerBackup, user,
     * billing address and shipping address
     *
     * @author Mingwei He
     * @param customer
     * @param user
     */
    void editCustomer(Customer customer, User user);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}
