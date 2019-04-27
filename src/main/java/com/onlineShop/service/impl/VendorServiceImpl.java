package com.onlineShop.service.impl;

/*
 *   Created by Solomon.
 *   10/19/2018
 *   online shopping.
 * */

import com.onlineShop.dao.VendorDao;
import com.onlineShop.model.Vendor;
import com.onlineShop.service.VendorService;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DynamicUpdate
public class VendorServiceImpl implements VendorService {

    @Autowired
    VendorDao vendorDao;

    @Override
    public Vendor findVendorById(int vendorId) {

        return vendorDao.getVendorById(vendorId);
    }


    //Created By Krishna

    @Override
    public List<Vendor> getAllVendor() {
        return vendorDao.getAllVendor();
    }

    @Override
    public void addVendor(Vendor vendor) {
        vendorDao.addVendor(vendor);
    }

    @Override
    public List<Vendor> getAllPendingVendor() {
        return vendorDao.getAllPendingVendor();
    }

    @Override
    public Vendor getPendingVendorById(int vendorId) {
        return vendorDao.getVendorByUserId(vendorId);
    }

    @Override
    public void updateVendorStatus(Vendor vendor) {
        vendorDao.updateVendorStatus(vendor);
    }
}
