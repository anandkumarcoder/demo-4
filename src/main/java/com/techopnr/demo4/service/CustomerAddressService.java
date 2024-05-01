package com.techopnr.demo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techopnr.demo4.model.CustomerAddress;
import com.techopnr.demo4.repository.CustomerAddressRepository;

@Service
public class CustomerAddressService {
@Autowired
private CustomerAddressRepository customerAddressRepository;


// constructor
public CustomerAddressService(CustomerAddressRepository customerAddressRepository) {
    this.customerAddressRepository = customerAddressRepository;
}

// creating records
public String createCustomerAddress(CustomerAddress customerAddress){
    customerAddressRepository.save(customerAddress);
    return "record created successfully";
}

// get all details

public List <CustomerAddress> getAllCustomerAddressDetails(){
    return customerAddressRepository.findAll();
}

// updating records
public String updateCustomerAddress(CustomerAddress customerAddress){
    customerAddressRepository.save(customerAddress);
    return "record updated successfully";
}



// pagination for getting all the details



// delete
public String deleteCustomerAddress(String customerId ){
    customerAddressRepository.deleteById(customerId);
    return "record deleted successfully";
}
}
