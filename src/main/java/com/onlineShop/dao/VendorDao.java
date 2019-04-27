package com.onlineShop.dao;

import com.onlineShop.model.Vendor;

import java.util.List;

public interface VendorDao {
    void editVendor(Vendor vendor);
    Vendor getVendorByUserId(int userId);
    public Vendor getVendorById(int vendorId);

    //By Krishna

    List<Vendor> getAllVendor();

    void addVendor(Vendor vendor);

    public  List<Vendor> getAllPendingVendor();

    public Vendor getPendingVendorById(int vendorId);

    public void updateVendorStatus(Vendor vendor);

}
