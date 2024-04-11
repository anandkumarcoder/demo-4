package com.techopnr.demo4.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techopnr.demo4.model.OndcVendor;

public interface OndcVendorRepository extends JpaRepository<OndcVendor, String> {
    @Query(value = "SELECT * FROM ondc_vendor", nativeQuery = true)
    Page<OndcVendor> getReportList(Pageable pageable);
}
