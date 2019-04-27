package com.onlineShop.model;
/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
public class Messages {

    @Id
    @GeneratedValue
    private int id;

    private int msgId;
    private String msgValue;

    public String getMsgValue() {
        return msgValue;
    }

    public void setMsgValue(String msgValue) {
        this.msgValue = msgValue;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
}
