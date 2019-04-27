package com.onlineShop.dao;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.CardDetail;
import com.onlineShop.model.Customer;

import java.util.List;

public interface CardDao {
        List<CardDetail> getCardList(int userId);
        Customer getCustomer(int userId);
        void addCardDetail(CardDetail cardDetail);
        CardDetail getCardById(int cardId);
}
