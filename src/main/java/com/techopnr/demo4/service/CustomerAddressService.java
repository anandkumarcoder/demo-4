package com.techopnr.demo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techopnr.demo4.model.CustomerAddress;
import com.techopnr.demo4.model.OndcVendor;
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

// records by id 
public CustomerAddress getCustomerAddressById(String customerId){
    return customerAddressRepository.findById(customerId).get();
}


// pagination for getting all the details
 public Page<CustomerAddress> getCustomerAddressWithPagination(Integer pageNumber, Integer pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        return customerAddressRepository.getReportList(pageRequest);
    }


// delete
public String deleteCustomerAddress(String customerId ){
    customerAddressRepository.deleteById(customerId);
    return "record deleted successfully";
}
}
