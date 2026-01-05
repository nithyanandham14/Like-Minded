package com.likeminded.repository;

import com.likeminded.model.VendorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<VendorProfile, String> {

    Optional<VendorProfile> findByUserId(String userId);

    boolean existsByContactEmail(String contactEmail);
}
