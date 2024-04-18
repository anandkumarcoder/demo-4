package com.techopnr.demo4.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.techopnr.demo4.model.OndcVendor;

public interface OndcVendorRepository extends JpaRepository<OndcVendor, String>, JpaSpecificationExecutor<OndcVendor> {

    // query for pagination
    @Query(value = "SELECT * FROM vendors", nativeQuery = true)
    Page<OndcVendor> getReportList(Pageable pageable);

    // like filterr
    @Query(value = "SELECT * FROM ecom_vendor WHERE vendor_address LIKE %?1% OR vendor_name LIKE %?1% OR vendor_tax_id LIKE %?1%", nativeQuery = true)
    Page<OndcVendor> findByCriteria(String query, Pageable pageable);

}
