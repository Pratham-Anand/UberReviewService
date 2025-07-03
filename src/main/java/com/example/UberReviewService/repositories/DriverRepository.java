package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    @Query(nativeQuery = true, value = "SELECT * FROM Driver WHERE id = :id AND license_number = :license") // RAW mysql query , error is thrown at runtime is query has issue
    Optional<Driver> rawfindByIdAndLicenseNumber(@Param("id") Long id,@Param("license")  String license);

    @Query("From Driver as d where d.id = :id AND d.licenseNumber = :license") // Hibernate query, error is thrown at compile time
    Optional<Driver> hqlfindByIdAndLicense(@Param("id")Long id, @Param("license")String ln);




}
