package com.onlineShop.service;

/* Created by Andres
* on 10/23/2018
 */
public interface EncryptionService {
    String EncryptPass (String pass);
    String DecryptPass (String epass);
}

