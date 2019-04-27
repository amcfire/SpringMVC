package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Mingwei on 10/14/2018.
 * Max sizes modified by Andres as part of authentication part 10/22/2018
 */
@Entity
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue
    private int userId;
    @NotEmpty(message = "Username(Email) may not be empty.")
    @Size(max = 500, message = "Maximum 500 characters limited.")
    @Pattern(regexp = "^([\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6})|$",
            message = "Invalid email address.")
    private String userName;
    @Size(max = 100, message = "Maximum 100 characters limited.")
    private String password;
    @Transient
    @Size(max = 100, message = "Maximum 100 characters limited.")
    private String oldPassword;
    @Transient
    @Size(max = 100, message = "Maximum 100 characters limited.")
    private String newPassword;
    @Transient
    @Size(max = 100, message = "Maximum 100 characters limited.")
    private String reEnterPassword;
    private String role;
    private boolean isActive;
    @Transient
    private Address address;
    @Transient
    @Valid
    private Customer customer;
    @Transient
    @Valid
    private Administrator administrator;
    @Transient
    @Valid
    private Vendor vendor;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReEnterPassword() {
        return reEnterPassword;
    }

    public void setReEnterPassword(String reEnterPassword) {
        this.reEnterPassword = reEnterPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
