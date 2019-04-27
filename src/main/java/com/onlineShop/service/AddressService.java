package com.onlineShop.service;

import com.onlineShop.model.Address;

public interface AddressService {

    void editAddress(Address address);
    Address getAddressByAddressId(int addressId);
}
