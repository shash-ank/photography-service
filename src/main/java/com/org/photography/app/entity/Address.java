package com.org.photography.app.entity;
import lombok.Getter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "country")
    private String country;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "house_no")
    private String houseNo;
    @Column(name = "landmark")
    private String landmark;

    @Column(name = "city")
    private String city;
    @Column(name = "area")
    private String area;
    @Column(name = "state")
    private String state;


    public Address() {
    }

    public Address(String country, String pincode, String area, String houseNo, Customer customer, String landmark, String city, String state) {
        this.country = country;
        this.customer=customer;
        this.pincode = pincode;
        this.houseNo = houseNo;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.area=area;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
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

//    public Customer getCustomer() {
//        return customer;
//    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", country='" + country + '\'' +
                ", pincode='" + pincode + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
