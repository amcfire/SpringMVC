package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by Mingwei on 10/14/2018.
 */
@Entity
@DynamicUpdate
public class Address {

    @Id
    @GeneratedValue
    private int addressId;
    @NotEmpty(message = "Street address may not be empty.")
    @Size(max = 500, message = "Maximum 500 characters limited.")
    private String street;
    @NotEmpty(message = "City may not be empty.")
    @Size(max = 100, message = "Maximum 100 characters limited.")
    private String city;
    @NotEmpty(message = "State may not be empty.")
    @Size(max = 50, message = "Maximum 50 characters limited.")
    private String state;
    @NotEmpty(message = "Post code may not be empty.")
    @Size(max = 50, message = "Maximum 50 characters limited.")
    private String zipCode;
    @NotEmpty(message = "Country may not be empty.")
    @Size(max = 100, message = "Maximum 100 characters limited.")
    private String country;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
