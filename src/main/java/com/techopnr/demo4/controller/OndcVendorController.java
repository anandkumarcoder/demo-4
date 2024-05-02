package com.techopnr.demo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techopnr.demo4.model.OndcVendor;
import com.techopnr.demo4.service.OndcVendorService;

@RestController
@RequestMapping("/ondcvendor")
public class OndcVendorController {

    @Autowired
    private OndcVendorService ondcVendorService;

    public OndcVendorController(OndcVendorService ondcVendorService) {
        this.ondcVendorService = ondcVendorService;
        // constructor based on cloudVendorService
    }

    // getting details as per id
    @GetMapping("{vendorId}")
    public OndcVendor getOndcVendorDetails(@PathVariable("vendorId") String vendorId) {

        return ondcVendorService.getOndcVendor(vendorId);
    }

    // control layer sends instruction to service layer and returns the method
    // applied in service layer

    // pagination
    @GetMapping
    public Page<OndcVendor> getAllOndcVendorWithPagination(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {

        return ondcVendorService.getAllOndcVendorWithPagination(pageNumber, pageSize);
    }

    // live filter

 
    @GetMapping("/searchByKeyword")
    public Page<OndcVendor> searchData(
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        
        // Create a Pageable object for pagination
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // Call the service method to search vendors by keyword
        return ondcVendorService.searchData(keyword, pageable);
    }

    // getting all the details in list

    /*
     * @GetMapping()
     * public List<OndcVendor> getAllVendorDetails(String vendorId){
     * 
     * return ondcVendorService.getAllOndcVendor();
     * }
     */

    // creating enteries
    @PostMapping
    public String createOndcVendorDetails(@RequestBody OndcVendor ondcVendor) {
        ondcVendorService.createOndcVendor(ondcVendor);
        return "Ondc vendor created successfully";
    }
    

    // updating enteries in DB
    @PutMapping
    public String updateOndcVendorDetails(@RequestBody OndcVendor ondcVendor) {

        ondcVendorService.updateOndcVendor(ondcVendor);
        return "cloud vendor updated successfully";

    }
}


/* 
 * 
 *    @GetMapping("/api/vendors/searchByKeyword")
    public Page<OndcVendor> searchData(
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        
        // Create a Pageable object for pagination
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // Call the service method to search vendors by keyword
        return ondcVendorService.searchData(keyword, pageable);
    }

 */