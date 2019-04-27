package com.onlineShop.dao;

import com.onlineShop.model.Administrator;
import com.onlineShop.model.Customer;
import com.onlineShop.model.User;

import java.util.List;

/**
 * Created By krish on Oct, 2018
 */
public interface AdminDao {

    void addCustomer(Customer customer);
    void update(Customer customer);

    User deleteCustomer(int userId);

    List<Customer> getAllCustomer();

    Customer getCustomerById(int id);

    List<Administrator> getAllAdmin();
    void addAdmin(Administrator administrator);
}
