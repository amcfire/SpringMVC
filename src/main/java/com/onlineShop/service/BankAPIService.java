package com.onlineShop.service;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import java.io.UnsupportedEncodingException;

public interface BankAPIService {
    public int callBankAPI(String cardNo, String expiredMonth, String expiredYear, String cvv, String ownerName, String zipCode, String purchaseAmnt) throws UnsupportedEncodingException;
}
