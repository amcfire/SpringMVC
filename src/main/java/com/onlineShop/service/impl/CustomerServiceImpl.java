package com.onlineShop.service.impl;

import com.onlineShop.dao.CustomerDao;
import com.onlineShop.dao.AddressDao;
import com.onlineShop.dao.UserDao;
import com.onlineShop.model.User;
import com.onlineShop.model.Customer;
import com.onlineShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AddressDao addressDao;
//asdas
    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }

    /**
     * Edit customer, user,
     * billing address and shipping address
     *
     * @author Mingwei He
     * @param customer
     * @param user
     */
    @Transactional
    public void editCustomer(Customer customer, User user){
//        // update customer
//        customerDao.editCustomer(customer);
//        // update billing address
//        BillingAddress ba = customer.getBillingAddress();
//        if (ba != null && !StringUtils.isEmpty(ba.getBillingAddressId()))
//            billingAddressDao.editBillingAddress(ba);
//        // update shipping address
//        ShippingAddress sa = customer.getShippingAddress();
//        if (sa != null && !StringUtils.isEmpty(sa.getShippingAddressId()))
//            addressDao.editShippingAddress(sa);
//        // update user
//        if(user != null && !StringUtils.isEmpty(user.getUsersId()))
//            userDao.editUser(user);

    }

    public Customer getCustomerById(int userId) {
        return customerDao.getCustomerByUserId(userId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username) {
        return customerDao.getCustomerByUsername(username);
    }
}
