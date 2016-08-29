package com.packt.webstore.domain;


public class Customer {

    private String customerId;
    private String name;
    private String address;
    boolean noOrdersMade;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.noOrdersMade = true;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isNoOrdersMade() {
        return noOrdersMade;
    }

    public void setNoOrdersMade(boolean noOrdersMade) {
        this.noOrdersMade = noOrdersMade;
    }

    @Override
    public String toString() {
        return "Customers name: " + name + ", address: " + address;
    }
}
