package com.packt.webstore.domain;


import javax.persistence.*;
import java.io.Serializable;


@Embeddable
public class Address implements Serializable {

    @Transient
    private static final long serialVersionUID =
            -530086768384258062L;

    @Column(name = "DOOR_NUMBER")
    private String doorNo;
    @Column(name = "STREET_NAME")
    private String streetName;
    @Column(name = "REGION_NAME")
    private String regionName;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ZIP_CODE")
    private String zipCode;

    public Address(){
        super();
    }

    public Address(String doorNo, String streetName,
                   String regionName, String state,
                   String country, String zipCode) {
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.regionName = regionName;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }


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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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
        if (!getRegionName().equals(address.getRegionName())) return false;
        if (!getState().equals(address.getState())) return false;
        if (!getCountry().equals(address.getCountry())) return false;
        return getZipCode().equals(address.getZipCode());

    }

    @Override
    public int hashCode() {
        int result = getDoorNo().hashCode();
        result = 31 * result + getStreetName().hashCode();
        result = 31 * result + getRegionName().hashCode();
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
                ", regionName='" + regionName + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
