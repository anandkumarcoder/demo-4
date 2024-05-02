package com.techopnr.demo4.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers_address")
// customers_address

public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private Integer zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "type")
    private String type;

    @Column(name = "comments")
    private String comments;

    @Column(name = "created_on")
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "is_favourite")
    private String isFavourite;

}
