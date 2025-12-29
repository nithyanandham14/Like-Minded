package com.likeminded.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class VendorResponse {

    private String vendorId;
    private String companyName;
    private String contactPersonName;
    private String contactEmail;
    private BigDecimal walletBalance;
}
