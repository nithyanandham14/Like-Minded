package com.likeminded.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRegisterRequest {

    private String name;
    private String email;
    private String college;
    @Column(nullable = false)
    private String password;
}
