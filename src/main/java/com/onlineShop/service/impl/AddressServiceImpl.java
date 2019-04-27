
package com.onlineShop.service.impl;


import com.onlineShop.dao.AddressDao;
import com.onlineShop.model.Address;
import com.onlineShop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;
    @Override
    public void editAddress(Address address) {
        addressDao.editAddress(address);
    }

    public Address getAddressByAddressId(int addressId){
        return addressDao.getAddressByAddressId(addressId);
    }
}
