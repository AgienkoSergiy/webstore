package com.packt.webstore.domain;


import com.packt.webstore.validator.PasswordMatches;
import com.packt.webstore.validator.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@PasswordMatches
@Entity
@Table(name = "USER")
public class Customer implements Serializable {


    private static final long  serialVersionUID =
            2284040482222162898L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer customerId;

    @NotNull
    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @Embedded
    private Address billingAddress;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NotNull
    @NotEmpty
    @ValidEmail
    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @NotEmpty
    @Transient
    private String matchingPassword;

    @Column(name = "ROLE")
    private String role;
    @Column(name = "ENABLED")
    private Boolean enabled;

    public Customer() {
        super();
        this.billingAddress = new Address();
        this.role = "ROLE_USER";
        this.enabled = true;
    }

    public Customer(Integer customerId, String name) {
        this();
        this.customerId = customerId;
        this.name = name;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Customers name: " + name + ", address: " + billingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getCustomerId().equals(customer.getCustomerId());
    }

    @Override
    public int hashCode() {
        if(getCustomerId()==null){
            return 0;
        }
        int result = getCustomerId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getBillingAddress().hashCode();
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }
}
