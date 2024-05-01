package com.techopnr.demo4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers_address")
// customers_address

public class CustomerAddress {

    @Id
    private int id;
    private String customerId;
    private String street;
    private String zipCode;
    private String city;
    private String type;
    private String comments;
    private String createdOn;
    private String isFavourite;

    public CustomerAddress() {

    }

    // constructor

    public CustomerAddress(int id, String customerId, String street, String zipCode, String city, String type,
            String comments, String createdOn, String isFavourite) {
        this.id = id;
        this.customerId = customerId;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.type = type;
        this.comments = comments;
        this.createdOn = createdOn;
        this.isFavourite = isFavourite;
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(String isFavourite) {
        this.isFavourite = isFavourite;
    }

}
