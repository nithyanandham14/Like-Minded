package com.likeminded.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Link to User (Auth table)
    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String contactPersonName;

    @Column(nullable = false, unique = true)
    private String contactEmail;

    @Column(nullable = false)
    private BigDecimal walletBalance = BigDecimal.ZERO;

    private boolean active = true;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
