package com.techopnr.demo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techopnr.demo4.model.CustomerAddress;
import com.techopnr.demo4.service.CustomerAddressService;

@RestController
@RequestMapping("/customer")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    // getting all the details in list
  /*   @GetMapping()
    public List<CustomerAddress> getAllDetails(String customerId) {
        return customerAddressService.getAllCustomerAddressDetails();

    } 
    // commented so that pagination could work
    */

    // creating records
    @PostMapping
    public String createCustomerAddress(@RequestBody CustomerAddress customerAddress) {
        customerAddressService.createCustomerAddress(customerAddress);
        return "customer address created in DB";
    }

    // updating records in DB

    @PutMapping("/{id}")
    public String updateCustomerAddress(@PathVariable("id") int id, @RequestBody CustomerAddress customerAddress) {
        // Assuming 'id' is used to identify the customer address to be updated
        customerAddress.setId(id); // Set the id of the customerAddress object to ensure it matches the path
                                   // variable
        customerAddressService.updateCustomerAddress(customerAddress);
        return "records updated in DB";
    }

    // get records by id
    // want to search by customer id but in postman it is happening as per id
    @GetMapping("{customerId}")
    public CustomerAddress getDetailsById(@PathVariable("customerId") String customerId) {
        return customerAddressService.getCustomerAddressById(customerId);
    }

    // pagination

    @GetMapping
    public Page<CustomerAddress>GetCustomerAddress(
        @RequestParam(value = "pageNo", defaultValue = "0" , required = false) Integer pageNo,
        @RequestParam(value = "pageSize", defaultValue = "4" , required = false) Integer pageSize){
return customerAddressService.getCustomerAddressWithPagination(pageNo, pageSize);
    }




    @DeleteMapping("{customerId}")
    public String deleteCustomerAddress(@PathVariable("customerId") String customerId) {
        customerAddressService.deleteCustomerAddress(customerId);
        return "records dele~ted from DB";
    }
}
