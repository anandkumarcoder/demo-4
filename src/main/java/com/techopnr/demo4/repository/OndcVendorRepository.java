package com.techopnr.demo4.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techopnr.demo4.model.OndcVendor;

public interface OndcVendorRepository extends JpaRepository<OndcVendor, String>, JpaSpecificationExecutor<OndcVendor> {

    // query for pagination
    @Query(value = "SELECT * FROM vendors", nativeQuery = true)
    Page<OndcVendor> getReportList(Pageable pageable);

    // like filterr
    /*
     * @Query(value =
     * "SELECT * FROM ecom_vendor WHERE vendor_address LIKE %?1% OR vendor_name LIKE %?1% OR vendor_tax_id LIKE %?1%"
     * , nativeQuery = true)
     * Page<OndcVendor> searchByQuery(String query, Pageable pageable);
     */

/*     @Query(value = "SELECT * FROM vendors v WHERE " +
            "(vendor_address like CONCAT('%', :vendorAddress, '%'))  OR LOWER(vendor_name like CONCAT('%', :query, '%')) OR (vendor_tax_id like CONCAT('%', :query, '%'))", nativeQuery = true)
    Page<OndcVendor> searchByQuery(@Param("query") String query, Pageable pageable); */


  /*   @Query(value = "SELECT * FROM ecom_vendor.vendors v WHERE " +
    "v.vendor_address LIKE %?1% OR " +
    "LOWER(v.vendor_name) LIKE LOWER(%?1%) OR " +
    "v.vendor_tax_id LIKE %?1%", nativeQuery = true)
Page<OndcVendor> searchByQuery(String query, Pageable pageable); */



/* @Query(value = "SELECT * FROM ecom_vendor.vendors WHERE vendor_address LIKE :searchTerm OR vendor_name LIKE :searchTerm OR vendor_tax_id LIKE :searchTerm", nativeQuery = true)
Page<OndcVendor> searchByQuery(@Param("searchTerm") String searchTerm, Pageable pageable); */


@Query(value = "SELECT * FROM ecom_vendor.vendors " +
            "WHERE vendor_address LIKE %?1% " +
            "OR vendor_name LIKE %?1% " +
            "OR vendor_tax_id LIKE %?1%",
            nativeQuery = true)
    Page<OndcVendor> searchByKeyword(String keyword, Pageable pageable);



/* SELECT *
FROM ecom_vendor.vendors
WHERE vendor_address LIKE '%updated%'
OR vendor_name LIKE '%updated%'
OR vendor_tax_id LIKE '%updated%'; */


  
}

/*
 * @Query(value =
 * "SELECT * FROM bookings b where ( (:orderId is null or  b.order_id like CONCAT('%',:orderId,'%')) and (:custName is null or b.cust_name like CONCAT('%',:custName,'%')) and (:custMobile is null or b.cust_mobile like CONCAT('%',:custMobile,'%')) and (b.booking_from in :bookingFrom) and (b.payment_type in :paymentType) and (:carNo is null or b.car_no=:carNo) and (:pickupAreaName is null or b.pickup_area_name like CONCAT('%',:pickupAreaName,'%') ) and (:pickupCity is null or b.pickup_city like CONCAT('%',:pickupCity,'%') ) and (:pickupZipcode is null or b.pickup_zipcode like CONCAT('%',:pickupZipcode,'%') ) and ( b.order_start_date_time between :fromDateTime and :toDateTime) and (:custInstruction is null or b.cust_instruction like CONCAT('%',:custInstruction,'%')) and (:notes is null or b.notes like CONCAT('%',:notes,'%') ) and (b.status in :status) and (:isMedicalJob is null or b.is_medical_job=:isMedicalJob) and (:isInvoiceJob is null or b.is_invoice_job=:isInvoiceJob))  order by b.booking_id desc"
 * , countQuery =
 * "SELECT count(*) FROM bookings b where ( (:orderId is null or  b.order_id like CONCAT('%',:orderId,'%')) and (:custName is null or b.cust_name like CONCAT('%',:custName,'%')) and (:custMobile is null or b.cust_mobile like CONCAT('%',:custMobile,'%')) and ( b.booking_from in :bookingFrom) and (b.payment_type in :paymentType) and (:carNo is null or b.car_no=:carNo) and (:pickupAreaName is null or b.pickup_area_name like CONCAT('%',:pickupAreaName,'%') ) and (:pickupCity is null or b.pickup_city like CONCAT('%',:pickupCity,'%') ) and (:pickupZipcode is null or b.pickup_zipcode like CONCAT('%',:pickupZipcode,'%') ) and ( b.order_start_date_time between :fromDateTime and :toDateTime) and (:custInstruction is null or b.cust_instruction like CONCAT('%',:custInstruction,'%')) and (:notes is null or b.notes like CONCAT('%',:notes,'%') ) and (b.status in :status) and (:isMedicalJob is null or b.is_medical_job=:isMedicalJob) and (:isInvoiceJob is null or b.is_invoice_job=:isInvoiceJob)) "
 * , nativeQuery = true)
 */