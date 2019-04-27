package com.onlineShop.service.impl;

import com.onlineShop.service.EncryptionService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptionServiceImpl implements EncryptionService {
    public final static String base ="projectmanagementonlineshoppingcompanyclas";

    public String EncryptPass(String str){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(base);
        String encryptedText = encryptor.encrypt(str);
        return encryptedText;
    }

    public  String  DecryptPass(String str){
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(base);
        String decryptedText = decryptor.decrypt(str);
        return new String(decryptedText);
    }

}
