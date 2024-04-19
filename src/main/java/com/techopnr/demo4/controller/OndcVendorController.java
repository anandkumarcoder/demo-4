package com.techopnr.demo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @GetMapping()
    public Page<OndcVendor> getAllOndcVendorWithPagination(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {

        return ondcVendorService.getAllOndcVendorWithPagination(pageNumber, pageSize);
    }

    // live filter

    @GetMapping("/search")
    public ResponseEntity<Page<OndcVendor>> search(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<OndcVendor> results = ondcVendorService.searchData(query, PageRequest.of(page, size));
        return ResponseEntity.ok(results);
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
