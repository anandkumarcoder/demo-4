package com.techopnr.demo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techopnr.demo4.model.CustomerAddress;
import com.techopnr.demo4.service.CustomerAddressService;

@RestController
@RequestMapping("/customer")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    // getting all the details in list
    @GetMapping()
    public List<CustomerAddress> getAllDetails(String customerId) {
        return customerAddressService.getAllCustomerAddressDetails();

    }

    // creating records
    @PostMapping
    public String createCustomerAddress(@RequestBody CustomerAddress customerAddress){
        customerAddressService.createCustomerAddress(customerAddress);
        return "customer address created in DB";
    }

    // updating records in DB

    @PutMapping
    public String updateCustomerAddress(@RequestBody CustomerAddress customerAddress){
        customerAddressService.updateCustomerAddress(customerAddress);
        return "records updated in DB";
    }

    @DeleteMapping("{customerId}")
    public String deleteCustomerAddress(@PathVariable("customerId") String customerId){
        customerAddressService.deleteCustomerAddress(customerId);
        return "records dele~ted from DB";
    }
}
