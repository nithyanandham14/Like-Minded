package com.likeminded.service;

import com.likeminded.dto.VendorRegisterRequest;
import com.likeminded.dto.VendorResponse;
import com.likeminded.model.VendorProfile;
import com.likeminded.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorResponse registerVendor(String userId, VendorRegisterRequest request) {

        VendorProfile vendor = VendorProfile.builder()
                .userId(userId)
                .companyName(request.getCompanyName())
                .contactPersonName(request.getContactPersonName())
                .contactEmail(request.getContactEmail())
                .build();

        VendorProfile savedVendor = vendorRepository.save(vendor);

        return mapToResponse(savedVendor);
    }

    public VendorResponse getVendorProfile(String userId) {

        VendorProfile vendor = vendorRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        return mapToResponse(vendor);
    }

    private VendorResponse mapToResponse(VendorProfile vendor) {
        return VendorResponse.builder()
                .vendorId(vendor.getId())
                .companyName(vendor.getCompanyName())
                .contactPersonName(vendor.getContactPersonName())
                .contactEmail(vendor.getContactEmail())
                .walletBalance(vendor.getWalletBalance())
                .build();
    }
}
