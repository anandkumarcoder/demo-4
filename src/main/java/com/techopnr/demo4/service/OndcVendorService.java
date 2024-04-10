package com.techopnr.demo4.service;

import java.util.List;

import com.techopnr.demo4.model.OndcVendor;

public interface OndcVendorService {

    public String createOndcVendor(OndcVendor ondcVendor);
    public String updateOndcVendor(OndcVendor ondcVendor);
    public OndcVendor getOndcVendor(String ondcVendorId);
    public List <OndcVendor> getAllOndcVendor(Integer pageNumber, Integer pageSize);
}
