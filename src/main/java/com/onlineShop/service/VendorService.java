package com.onlineShop.service;

/*
*   Created by Solomon.
*   10/19/2018
*   online shopping.
* */

import com.onlineShop.model.Product;
import com.onlineShop.model.Vendor;

import java.util.List;

public interface VendorService {

    Vendor findVendorById(int vendorId);


    //Created by Krishna

    public List<Vendor> getAllVendor();

    public void addVendor(Vendor vendor);

    public  List<Vendor> getAllPendingVendor();

    public Vendor getPendingVendorById(int vendorId);

    public void updateVendorStatus(Vendor vendor);
}
