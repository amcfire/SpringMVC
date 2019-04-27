package com.onlineShop.service;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.Result;

public interface EmailService {
    public Result sendEmail(String emailAddress, String Subject, String email);
}
