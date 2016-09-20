package com.packt.webstore.domain;


import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID =
            -530086768384258062L;
    private String doorNo;
    private String streetName;
    private String areaName;
    private String state;
    private String country;
    private String zipCode;
    // add getters and setters for all the fields here.
    // Override equals and hashCode based on all the fields.
    // the code for the same is available in the code bundle which
    // can be downloaded from www.packtpub.com/support


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!getDoorNo().equals(address.getDoorNo())) return false;
        if (!getStreetName().equals(address.getStreetName())) return false;
        if (!getAreaName().equals(address.getAreaName())) return false;
        if (!getState().equals(address.getState())) return false;
        if (!getCountry().equals(address.getCountry())) return false;
        return getZipCode().equals(address.getZipCode());

    }

    @Override
    public int hashCode() {
        int result = getDoorNo().hashCode();
        result = 31 * result + getStreetName().hashCode();
        result = 31 * result + getAreaName().hashCode();
        result = 31 * result + getState().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getZipCode().hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Address{" +
                "doorNo='" + doorNo + '\'' +
                ", streetName='" + streetName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
