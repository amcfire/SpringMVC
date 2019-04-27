package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Mingwei on 10/14/2018.
 */
@Entity
@DynamicUpdate
public class Customer {

    @Id
    @GeneratedValue
    private int customerId;
    @NotEmpty(message = "First name may not be empty.")
    @Size(max = 100, message = "Maximum 100 characters limited.")
    private String firstName;
    @NotBlank(message = "Last name may not be empty.")
    @Size(max = 100, message = "Maximum 100 characters limited.")
    private String lastName;
    @NotBlank(message = "Phone number may not be empty.")
    @Pattern(regexp = "^(\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4}))|$", message = "Invalid phone number.")
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
