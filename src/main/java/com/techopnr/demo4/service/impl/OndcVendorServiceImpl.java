package com.techopnr.demo4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techopnr.demo4.model.OndcVendor;
import com.techopnr.demo4.repository.OndcVendorRepository;
import com.techopnr.demo4.service.OndcVendorService;

@Service
public class OndcVendorServiceImpl implements OndcVendorService {

    // repository anotation
    private final OndcVendorRepository ondcVendorRepository;

    @Autowired
    public OndcVendorServiceImpl(OndcVendorRepository ondcVendorRepository) {
        this.ondcVendorRepository = ondcVendorRepository;
    } // constructor based on cloudVendorRepository

    @Override
    public String createOndcVendor(OndcVendor ondcVendor) {
        ondcVendorRepository.save(ondcVendor);
        return "created successfully";
    }

    @Override
    public Page<OndcVendor> getAllOndcVendor(Integer pageNumber, Integer pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        return ondcVendorRepository.findAll(pageRequest);
    }

    @Override
    public OndcVendor getOndcVendor(String ondcVendorId) {

        return ondcVendorRepository.findById(ondcVendorId).get();
    }

    @Override
    public String updateOndcVendor(OndcVendor ondcVendor) {

        ondcVendorRepository.save(ondcVendor);
        return "updated successfully";
    }

}
