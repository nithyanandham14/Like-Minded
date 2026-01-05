package com.likeminded.dto;

import lombok.Data;

@Data
public class VendorRegisterRequest {

    private String companyName;
    private String contactPersonName;
    private String contactEmail;
}
