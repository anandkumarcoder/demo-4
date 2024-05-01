package com.techopnr.demo4.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techopnr.demo4.model.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,String>,JpaSpecificationExecutor<CustomerAddress>{

}
