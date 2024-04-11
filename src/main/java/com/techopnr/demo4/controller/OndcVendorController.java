package com.techopnr.demo4.controller;

import java.util.List;

import org.hibernate.service.Service;
import org.springframework.data.domain.Page;
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
    
     private  OndcVendorService ondcVendorService;

    public OndcVendorController(OndcVendorService ondcVendorService) {
        this.ondcVendorService = ondcVendorService;
        // constructor based on cloudVendorService
    }

    @GetMapping("{vendorId}")
    public OndcVendor getOndcVendorDetails(@PathVariable("vendorId") String vendorId){

        return ondcVendorService.getOndcVendor(vendorId);
    }


    @GetMapping()
    public Page<OndcVendor> getAllVendorDetails( @RequestParam(value = "pageNumber", defaultValue ="1",required = false)Integer pageNumber,
    @RequestParam(value = "pageSize", defaultValue ="2",required = false) Integer pageSize){
       
        return ondcVendorService.getAllOndcVendor(pageNumber, pageSize);
    }

    // @GetMapping()
    // public List<OndcVendor> getAllVendorDetails( ){
    // //    List <OndcVendor> allProducts = Service.findAll()
    //     // return ondcVendorService.getAllOndcVendor();
    // }

    /* @GetMapping
    public Page<OndcVendor> getAllVendorDetails(
        @RequestParam(name = "pageNo" , defaultValue = "0") int pageNo,
        @RequestParam(name = "pageSize" , defaultValue = "2") int pageSize ){
            return ondcVendorService.getAllVendorDetails(pageNo,pageSize);
        } */
   


    @PostMapping
    public String createOndcVendorDetails(@RequestBody OndcVendor ondcVendor){
        ondcVendorService.createOndcVendor(ondcVendor);
        return "Ondc vendor created successfully";
    }


    @PutMapping
    public String updateOndcVendorDetails(@RequestBody OndcVendor ondcVendor) {

        ondcVendorService.updateOndcVendor(ondcVendor);
        return "cloud vendor updated successfully";

    }
}
