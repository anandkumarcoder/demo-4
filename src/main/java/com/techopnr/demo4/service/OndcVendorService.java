package com.techopnr.demo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techopnr.demo4.model.OndcVendor;
import com.techopnr.demo4.repository.OndcVendorRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class OndcVendorService {

    @Autowired
    private OndcVendorRepository ondcVendorRepository;

    // service layer interacts with repository layer and model layer

    // constructor
    public OndcVendorService(OndcVendorRepository ondcVendorRepository) {
        this.ondcVendorRepository = ondcVendorRepository;
    }

    // creating record
    public String createOndcVendor(OndcVendor ondcVendor) {
        // service layer interacting with model layer/ class
        ondcVendorRepository.save(ondcVendor);
        return "created successfully";
    }

    // updating record
    public String updateOndcVendor(OndcVendor ondcVendor) {

        ondcVendorRepository.save(ondcVendor);
        return "updated successfully";
    }

    // records by id

    public OndcVendor getOndcVendor(String ondcVendorId) {

        return ondcVendorRepository.findById(ondcVendorId).get();
    }

    // getting all details

    public List<OndcVendor> getAllOndcVendor() {

        return ondcVendorRepository.findAll();
    }

    // pagination
    public Page<OndcVendor> getAllOndcVendorWithPagination(Integer pageNumber, Integer pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        return ondcVendorRepository.getReportList(pageRequest);
    }

    // like filter
    public Page<OndcVendor> searchData(String query, Pageable pageable) {
        return ondcVendorRepository.searchByKeyword(query, pageable);
    }
}
