package com.techopnr.demo4.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.techopnr.demo4.model.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,String>,JpaSpecificationExecutor<CustomerAddress>{


    @Query(value = "SELECT * FROM customers_address", nativeQuery = true)
    Page<CustomerAddress> getReportList(Pageable pageable);
}
