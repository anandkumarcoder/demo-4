package com.techopnr.demo4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendors")
public class OndcVendor {
    // modal class with properties/attributes

    @Id
    private String vendorId;
    private String vendorName;
    private String vendorPhoneNumber;
    private String vendorEmail;
    private String vendorAddress;
    private String vendorTaxId;

    
    // empty constructor
    public OndcVendor() {

    }

    // constructor with argument in place

    public OndcVendor(String vendorId, String vendorName, String vendorPhoneNumber, String vendorEmail,
            String address, String vendorTaxId) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorPhoneNumber = vendorPhoneNumber;
        this.vendorEmail = vendorEmail;
        this.vendorAddress = address;
        this.vendorTaxId = vendorTaxId;
    }



    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorTaxId() {
        return vendorTaxId;
    }

    public void setVendorTaxId(String vendorTaxId) {
        this.vendorTaxId = vendorTaxId;
    }

}
