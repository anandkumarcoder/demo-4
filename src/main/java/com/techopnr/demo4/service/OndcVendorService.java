package com.techopnr.demo4.service;

import org.springframework.data.domain.Page;

import com.techopnr.demo4.model.OndcVendor;

public interface OndcVendorService {

    public String createOndcVendor(OndcVendor ondcVendor);

    public String updateOndcVendor(OndcVendor ondcVendor);

    public OndcVendor getOndcVendor(String ondcVendorId);

    public Page<OndcVendor> getAllOndcVendor(Integer pageNumber, Integer pageSize);
}
