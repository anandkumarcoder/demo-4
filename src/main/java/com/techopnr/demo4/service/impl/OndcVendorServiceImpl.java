package com.techopnr.demo4.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techopnr.demo4.model.OndcVendor;
import com.techopnr.demo4.repository.OndcVendorRepository;
import com.techopnr.demo4.service.OndcVendorService;



// Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'ondcVendorServiceImpl' defined in file [D:\Anand\java 2024\demo-4\demo-4\target\classes\com\techopnr\demo4\service\impl\OndcVendorServiceImpl.class]:
@Service
public class OndcVendorServiceImpl implements OndcVendorService {


  
// repository  anotation 
    OndcVendorRepository ondcVendorRepository;

    public OndcVendorServiceImpl(OndcVendorRepository ondcVendorRepository) {
        this.ondcVendorRepository = ondcVendorRepository;
    }  // constructor based on  cloudVendorRepository 


    @Override
    public String createOndcVendor(OndcVendor ondcVendor) {
        ondcVendorRepository.save(ondcVendor);
        return "created successfully";
    }


    @Override
    public List<OndcVendor> getAllOndcVendor() {
        // TODO Auto-generated method stub
        
        return ondcVendorRepository.findAll();
    }


    @Override
    public OndcVendor getOndcVendor(String ondcVendorId) {
        // TODO Auto-generated method stub
        return ondcVendorRepository.findById(ondcVendorId).get();
    }


    @Override
    public String updateOndcVendor(OndcVendor ondcVendor) {
        // TODO Auto-generated method stub
        return null;
    }




    
}
