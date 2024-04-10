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

// Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'ondcVendorServiceImpl' defined in file [D:\Anand\java 2024\demo-4\demo-4\target\classes\com\techopnr\demo4\service\impl\OndcVendorServiceImpl.class]:
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
    public List<OndcVendor> getAllOndcVendor(Integer pageNumber, Integer pageSize) {
        // TODO Auto-generated method stub

        /* int  pageSize = 5;
        int pageNumber = 1; */
        
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page <OndcVendor> page = ondcVendorRepository.findAll(pageRequest);


        return page.getContent();
    }

    @Override
    public OndcVendor getOndcVendor(String ondcVendorId) {
        // TODO Auto-generated method stub
        return ondcVendorRepository.findById(ondcVendorId).get();
    }

    @Override
    public String updateOndcVendor(OndcVendor ondcVendor) {
        // TODO Auto-generated method stub
        ondcVendorRepository.save(ondcVendor);
        return "updated successfully";
    }

}
