package com.onlineShop.dao;


import com.onlineShop.model.Address;

/**
 * Created by Mingwei on 10/12/2018
 */
public interface AddressDao {
    void editAddress(Address address);
    Address getAddressByAddressId(int addressId);
}
