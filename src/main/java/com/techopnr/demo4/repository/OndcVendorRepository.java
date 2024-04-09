package com.techopnr.demo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techopnr.demo4.model.OndcVendor;

public interface OndcVendorRepository  extends JpaRepository <OndcVendor, String> {

}


// Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'ondcVendorRepository' defined in com.techopnr.demo4.repository.OndcVendorRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Not a managed type: class com.techopnr.demo4.model.OndcVendor