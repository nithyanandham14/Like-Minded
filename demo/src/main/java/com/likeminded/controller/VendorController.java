package com.likeminded.controller;

import com.likeminded.dto.VendorDashboardResponse;
import com.likeminded.dto.VendorRegisterRequest;
import com.likeminded.dto.VendorResponse;
import com.likeminded.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    /**
     * Register Vendor Profile
     */
    @PostMapping("/register")
    public VendorResponse registerVendor(
            Authentication authentication,
            @RequestBody VendorRegisterRequest request) {

        String userId = authentication.getName(); // From JWT
        return vendorService.registerVendor(userId, request);
    }

    /**
     * Vendor Dashboard / Profile
     */
    @GetMapping("/profile")
    public VendorResponse getVendorProfile(Authentication authentication) {

        String userId = authentication.getName();
        return vendorService.getVendorProfile(userId);
    }
    @GetMapping("/dashboard")
    public VendorDashboardResponse getDashboard(Authentication authentication) {

        String vendorId = authentication.getName();

        return vendorService.getDashboard(vendorId);
    }
}
