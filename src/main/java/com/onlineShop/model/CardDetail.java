package com.onlineShop.model;
/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@DynamicUpdate
public class CardDetail {

    @Id
    @GeneratedValue
    private int cardId;

    @NotNull(message="Must insert card holder name.")
    private String cardHolderName;
    private String cardType;
    @Pattern(regexp="\\d{16}", message="Card number must be 16 digits.")
    private String cardNumber;
    @DateTimeFormat(pattern = "MM/yyyy")
    private Date cardExp;
    @Pattern(regexp="\\d{3}", message="CVV must be 3 digits.")
    private String securityNumber;
    @Pattern(regexp="\\d{5}", message="Zip code must be 5 digits.")
    private String zipCode;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @Transient
    private int expMonth;
    @Transient
    private int expYear;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getCardExp() {
        return cardExp;
    }

    public void setCardExp(Date cardExp) {
        this.cardExp = cardExp;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }
}
